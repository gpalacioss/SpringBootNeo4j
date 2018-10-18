package com.practica.primerEjemplo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
/**
 * La Anotacion @RelationshipEntity indica que el pojo es la relacion entre los nodos
 * debe contener las entidades relacionadas 
 * se le indica que nodo es el inicio y cual es el final con las anotaciones @StartNode y @EndNode
 * @author usuario
 *
 */
@RelationshipEntity
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private List<String> roles = new ArrayList<>();
	
	/**
	 * En este caso la clase persona representa el nodo que da inicio a la relacion
	 */
	@StartNode
	private Person person;
	
	/**
	 * En este caso la clase movie representa el nodo final de la relacion
	 */
	@EndNode
	private Movie movie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	

}
