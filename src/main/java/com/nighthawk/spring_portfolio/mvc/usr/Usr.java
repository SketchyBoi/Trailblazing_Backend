package com.nighthawk.spring_portfolio.mvc.usr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import static jakarta.persistence.FetchType.EAGER;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usr {

    // automatic unique identifier for Usr record
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min=5)
    @Column(unique=true)
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;
    @ManyToMany(fetch = EAGER)
    private Collection<UsrRole> roles = new ArrayList<>();
    private Map<String,Map<String, Object>> stats = new HashMap<>(); 

    public Usr(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    // Initialize static test data 
    public static Usr[] init() {

        // basics of class construction
        Usr p1 = new Usr("hi@test.com", "123Toby!", "Thomas Edison");

        // basics of class construction
        Usr p2 = new Usr("test2@gmail.com", "kendallsImpossibleToGuessPassw0rd", "Kendall Reist");

        Usr p3 = new Usr("drewreedyo@gmail.com", "insecure", "Drew Reed");
        
        Usr p4 = new Usr("js@test.com", "pass", "js");
        Usr usrs[] = {p1, p2, p3, p4};
        return(usrs);
    }

    public static void main(String[] args) {
        // obtain Usr from initializer
        Usr usrs[] = init();

        // iterate using "enhanced for loop"
        for (Usr usr : usrs) {
            System.out.println(usr);  // print object
        }
    }

}