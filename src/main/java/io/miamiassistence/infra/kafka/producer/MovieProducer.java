package io.miamiassistence.infra.kafka.producer;

import io.miamiassistence.domain.model.Movie;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MovieProducer {

    @Inject @Channel("movies")
    Emitter<Record<Integer, String>> emitter;

    public void sendMovieToKafka(Movie movie) {
        emitter.send(Record.of(movie.year, movie.title));
    }
}