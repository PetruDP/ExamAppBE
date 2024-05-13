package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {
    Optional<List<UserMovie>> findAllByUserId(Long userId);
    UserMovie findByUserIdAndMovieId(Long userId, String movieId);

}
