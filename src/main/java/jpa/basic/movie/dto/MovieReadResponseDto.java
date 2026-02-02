package jpa.basic.movie.dto;

import jpa.basic.movie.domain.Movie;

import java.time.LocalDateTime;

public record MovieReadResponseDto(
        Long id, String title, LocalDateTime createdAt, LocalDateTime modifiedAt)
{
    public MovieReadResponseDto(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getCreatedAt(), movie.getLastModifiedBy());
    }
}
