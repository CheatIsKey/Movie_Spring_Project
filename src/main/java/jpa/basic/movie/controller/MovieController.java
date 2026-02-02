package jpa.basic.movie.controller;

import jpa.basic.movie.dto.*;
import jpa.basic.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<MovieCreateResponseDto> createMovie(@RequestBody MovieCreateRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(request));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieReadAllResponseDto>> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<MovieReadResponseDto> getMovie(@PathVariable Long movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<MovieUpdateResponseDto> updateMovie(@PathVariable Long movieId, @RequestBody MovieUpdateRequestDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(movieId, request));
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
