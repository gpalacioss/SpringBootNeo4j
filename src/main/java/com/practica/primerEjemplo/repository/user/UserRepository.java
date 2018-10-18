package com.practica.primerEjemplo.repository.user;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.practica.primerEjemplo.models.user.User;
import java.lang.String;

public interface UserRepository extends Neo4jRepository<User, Long>{
	
	@Query("MATCH (u:User) where u.username={username} return u")
	User findByUsername(@Param("username") String username);

}
