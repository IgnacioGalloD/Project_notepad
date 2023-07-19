package com.notecreation.note.repository;

import com.notecreation.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

    List<Note> findByArchivedTrueAndDeletedFalse();

    List<Note> findByArchivedFalseAndDeletedFalse();
}
