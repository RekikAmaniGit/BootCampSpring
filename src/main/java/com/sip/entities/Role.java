package com.sip.entities;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}