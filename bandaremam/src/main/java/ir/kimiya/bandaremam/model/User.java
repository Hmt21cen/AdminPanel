package ir.kimiya.bandaremam.model;

import ir.kimiya.bandaremam.model.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "users" ,uniqueConstraints= @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surName;

   @Column(name = "email")
    private String email;

   @Column(name = "active")
    private int active;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
               joinColumns = @JoinColumn(name = "users_id",referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "roles_id",referencedColumnName = "id"))
    private Set<Role> role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String encode) {
        this.password = encode;
    }

    public String getUsername() {
        return username;
    }
}