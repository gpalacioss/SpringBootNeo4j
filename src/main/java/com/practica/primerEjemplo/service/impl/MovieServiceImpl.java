package com.practica.primerEjemplo.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.primerEjemplo.models.Movie;
import com.practica.primerEjemplo.repository.MovieRepository;
import com.practica.primerEjemplo.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	

	public Map<String, Object> graph(int limit){
		Collection<Movie> result = movieRepository.graph(limit);
		return null; //toD3Format(result);
	}
	
	public Movie findByTitle(String title) {
		Movie mov = movieRepository.findByTitle(title);
		return mov;
	}
	
	public List<Movie> getAllMovie(){
		return movieRepository.findAll().stream().collect(Collectors.toList());
	}
	
	public List<Movie> findMovieActedByActor(String nombreActor){
		return movieRepository.findMovieActedByName(nombreActor).stream().collect(Collectors.toList());
	}
}
