package jpa.basic.movie.dto;

import jpa.basic.movie.domain.Movie;

import java.time.LocalDateTime;

public record MovieCreateResponseDto(
        Long id, String title, LocalDateTime createdAt, LocalDateTime modifiedAt
) {
    public MovieCreateResponseDto(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getCreatedAt(), movie.getLastModifiedBy());
    }
}
