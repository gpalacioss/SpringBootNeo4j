package com.practica.primerEjemplo.service;

import java.util.List;
import java.util.Map;

import com.practica.primerEjemplo.models.Movie;

public interface MovieService {
	
	public Map<String, Object> graph (int limit);
	
	public Movie findByTitle(String title);
	
	/**
	 * Regresa la lista de todas las peliculas
	 * @return
	 */
	public List<Movie> getAllMovie();
	
	/**
	 * Regresa una lista de peliculas donde ha actuado algun actor
	 * @param nombreActor
	 * @return
	 */
	public List<Movie> findMovieActedByActor(String nombreActor);

}
