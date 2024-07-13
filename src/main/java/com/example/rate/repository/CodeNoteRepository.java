package com.example.rate.repository;

import com.example.rate.models.CodeNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeNoteRepository extends JpaRepository<CodeNote,Long> {
    Optional<CodeNote> findByName(String name);


}
