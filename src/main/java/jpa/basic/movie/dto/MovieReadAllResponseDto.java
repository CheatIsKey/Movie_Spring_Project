package jpa.basic.movie.dto;

import jpa.basic.movie.domain.Movie;

public record MovieReadAllResponseDto(
        Long id, String title
) {
    public MovieReadAllResponseDto(Movie movie) {
        this(movie.getId(), movie.getTitle());
    }
}
