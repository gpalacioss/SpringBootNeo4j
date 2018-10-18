package com.practica.primerEjemplo.repository;

import java.util.Collection;


import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.practica.primerEjemplo.models.Movie;

public interface MovieRepository extends Neo4jRepository<Movie, Long>{
	
	
	@Query("MATCH (m:Movie)-[r:ACTED_IN]-> (a:Person) RETURN m,r,a  LIMIT {limit}")
	Collection<Movie> graph(@Param("limit") int limit);
	
	
	Movie findByTitle(@Param("title") String title);
	
	Collection<Movie> findAll();
	
	@Query("MATCH(a:Person)-[:ACTED_IN]->(m:Movie) WHERE a.name={nombreActor} RETURN m")
	Collection<Movie> findMovieActedByName(@Param("nombreActor") String nombreActor);
	
}
