package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
