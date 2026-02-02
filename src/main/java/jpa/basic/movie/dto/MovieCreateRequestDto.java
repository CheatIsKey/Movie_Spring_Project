package jpa.basic.movie.dto;

import jpa.basic.movie.domain.Movie;

public record MovieCreateRequestDto(
        String title
) {
    public MovieCreateRequestDto(Movie movie) {
        this(movie.getTitle());
    }
}
