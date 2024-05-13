package com.imeghebe.jwt.backend.repositories;

import com.imeghebe.jwt.backend.entites.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Long> {
}
