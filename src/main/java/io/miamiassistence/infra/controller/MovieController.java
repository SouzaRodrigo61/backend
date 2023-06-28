package io.miamiassistence.infra.controller;

import io.miamiassistence.domain.model.Movie;
import io.miamiassistence.infra.kafka.producer.MovieProducer;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {

  @Inject
  MovieProducer producer;

  @POST
  public Response add(Movie movie) {
    producer.sendMovieToKafka(movie);
    // Return an 202 - Accepted response.
    return Response.accepted().build();
  }
}
