package jpa.basic.movie.service;

import jpa.basic.movie.domain.Movie;
import jpa.basic.movie.dto.*;
import jpa.basic.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieCreateResponseDto create(MovieCreateRequestDto request) {
        Movie movie = new Movie(request.title());
        movieRepository.save(movie);

        return new MovieCreateResponseDto(movie);
    }

    @Transactional(readOnly = true)
    public List<MovieReadAllResponseDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .map(MovieReadAllResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public MovieReadResponseDto getMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("해당 영화는 없습니다."));

        return new MovieReadResponseDto(movie);
    }

    @Transactional
    public MovieUpdateResponseDto updateMovie(Long movieId, MovieUpdateRequestDto request) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("해당 영화는 없습니다."));

        movie.updateTitle(request.title());
        return new MovieUpdateResponseDto(movie);
    }

    @Transactional
    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);

        if (!exists) {
            throw new NoSuchElementException("해당 영화는 없습니다.");
        }
        movieRepository.deleteById(movieId);
    }
}
