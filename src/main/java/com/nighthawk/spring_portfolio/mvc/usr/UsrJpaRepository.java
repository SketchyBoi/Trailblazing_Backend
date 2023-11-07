package com.nighthawk.spring_portfolio.mvc.usr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Extends the JpaRepository interface from Spring Data JPA.
-- Java Persistent API (JPA) - Hibernate: map, store, update and retrieve database
-- JpaRepository defines standard CRUD methods
-- Via JPA the developer can retrieve database from relational databases to Java objects and vice versa.
 */
public interface UsrJpaRepository extends JpaRepository<Usr, Long> {
    Usr findByEmail(String email);

    List<Usr> findAllByOrderByNameAsc();

    // JPA query, findBy does JPA magic with "Name", "Containing", "Or", "Email", "IgnoreCase"
    List<Usr> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
    
    Usr findByEmailAndPassword(String email, String password);

    // Custom JPA query
    @Query(
            value = "SELECT * FROM Person p WHERE p.name LIKE ?1 or p.email LIKE ?1",
            nativeQuery = true)
    List<Usr> findByLikeTermNative(String term);
    /*
      https://www.baeldung.com/spring-data-jpa-query
    */
}