package com.sip.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private DataSource dataSource;
    @Value("${spring.queries.users-query}")
    private String usersQuery;
    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    //1)Authentication
    protected void configure(AuthenticationManagerBuilder auth) // cette méthode permet d'ouvrir la connexion 
            throws Exception {
        auth.
                jdbcAuthentication() //t7el connexion
                .usersByUsernameQuery(usersQuery) //tjib l user
                .authoritiesByUsernameQuery(rolesQuery) //tjib les roles bte3 l user heka
                .dataSource(dataSource) // l base de données mawjouda fl application.properties
                .passwordEncoder(bCryptPasswordEncoder); // avec password crytpé
    }

    @Override

    //2)Autorisation
    protected void configure(HttpSecurity http) throws Exception {

        http.
                authorizeRequests()
                .antMatchers("/").permitAll() // accès pour tous users
                .antMatchers("/login").permitAll() // accès pour tous users
                .antMatchers("/registration").permitAll() // accès pour tous users
                .antMatchers("/role/**").permitAll()
                .antMatchers("/accounts/**").permitAll()
                .antMatchers("/provider/**").hasAnyAuthority("ADMIN", "SUPERADMIN")
                .antMatchers("/article/**").hasAnyAuthority("USER", "SUPERADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin() // ki ta3ml login: l'accès de fait via un formulaire

                .loginPage("/login").failureUrl("/login?error=true") // en cas de login 8alet: fixer la page login

                .defaultSuccessUrl("/home") //en cas login s7i7: page d'accueil après login avec succès
                .usernameParameter("email") // paramètres d'authentifications login et password
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // route de deconnexion ici /logut
                .logoutSuccessUrl("/login").and().exceptionHandling() // une fois deconnecté redirection vers login

                .accessDeniedPage("/403");
    }

    // laisser l'accès aux ressources
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/front/**","/images/**","/css/**");
    }

}