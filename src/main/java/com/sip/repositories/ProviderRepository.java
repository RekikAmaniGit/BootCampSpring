package com.sip.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.entities.Article;
import com.sip.entities.Provider;


@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
	
	//List<Provider> findByName(String name); HQL
		@Query("FROM Article a WHERE a.provider.id = ?1")//?1 signifie le premier parametre dans ce cas 1 s'il y a ?2 ça signifie le parametre 2
		List<Article> findArticlesByProvider(long id);


}
