package com.practica.primerEjemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practica.primerEjemplo.models.Movie;
import com.practica.primerEjemplo.service.MovieService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/findByTitle")
	public Movie findMovieByTitle(@RequestParam String title) {
		Movie result = movieService.findByTitle(title);
		System.out.println("Valor de la pelicula:: " + result.getTitle());
		return result;
	}
	
	@RequestMapping(value = "/getAllMovie",method = RequestMethod.GET)
	public List<Movie> findAllMovie(){
		List<Movie> result = movieService.getAllMovie();
		result.forEach(m -> {
			System.out.println("Nombre de las peliculas:: " + m.getTitle());
		});
		return result;
	}
	
	@RequestMapping(value = "/byActor", method = RequestMethod.GET)
	public List<Movie> findMovieByActor(@RequestParam String nombreActor){
		List<Movie> result = movieService.findMovieActedByActor(nombreActor);
		result.forEach(m -> {
			System.out.println("pelicula:: " + m.getTitle());
		});
		return result;
	}
	
}
