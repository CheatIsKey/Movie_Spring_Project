package jpa.basic.movie.dto;

import jpa.basic.movie.domain.Movie;

import java.time.LocalDateTime;

public record MovieUpdateResponseDto(
        Long id, String title, LocalDateTime createdAt, LocalDateTime modifiedAt
) {
    public MovieUpdateResponseDto(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getCreatedAt(), movie.getLastModifiedBy());
    }
}
