package com.notecreation.note.service.impl;

import com.notecreation.note.domain.Note;
import com.notecreation.note.dto.NoteDTO;
import com.notecreation.note.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notecreation.note.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements INoteService {
    private final NoteRepository repo;                                                  // see

    @Autowired
    public NoteServiceImpl(NoteRepository repo){
        this.repo=repo;                                                                 // see
    }

    @Override
    public NoteDTO createNote(NoteDTO note){
        Note savedNote = repo.save(NoteDTO.toEntity(note));
        return NoteDTO.toDTO(savedNote);
    }

    @Override
    public NoteDTO editNote(Integer id, NoteDTO note) {
        Note editedNote = repo.findById(id).orElseThrow();
        editedNote.setTitle(note.getTitle());
        editedNote.setContent(note.getContent());
        editedNote.setArchived(note.isArchived());
        editedNote.setDeleted(note.isDeleted());
        return NoteDTO.toDTO(editedNote);
    }

    @Override
    public NoteDTO deleteNote(Integer id, NoteDTO note) {
        Note deletedNote = repo.findById(id).orElseThrow();
        deletedNote.setTitle(note.getTitle());
        deletedNote.setContent(note.getContent());
        deletedNote.setArchived(note.isArchived());
        deletedNote.setDeleted(true);                       // change here
        return NoteDTO.toDTO(deletedNote);
    }

    @Override
    public NoteDTO archiveNote(Integer id, NoteDTO note) {
        Note archivedNote = repo.findById(id).orElseThrow();
        archivedNote.setTitle(note.getTitle());
        archivedNote.setContent(note.getContent());
        archivedNote.setDeleted(note.isDeleted());
        archivedNote.setArchived(true);                     // change here
        return NoteDTO.toDTO(archivedNote);
    }

    @Override
    public NoteDTO unarchiveNote(Integer id, NoteDTO note) {
        Note unarchivedNote = repo.findById(id).orElseThrow();
        unarchivedNote.setTitle(note.getTitle());
        unarchivedNote.setContent(note.getContent());
        unarchivedNote.setDeleted(note.isDeleted());
        unarchivedNote.setArchived(false);                  // change here
        return NoteDTO.toDTO(unarchivedNote);
    }

    @Override
    public List<NoteDTO> listArchivedNote() {
        List<Note> savedArchivedNotes = repo.findByArchivedTrue();
        List<NoteDTO> readedArchivedNotes = new ArrayList<>();
        for(Note note:savedArchivedNotes){
            readedArchivedNotes.add(NoteDTO.toDTO(note));
        }
        return readedArchivedNotes;
    }

    @Override
    public List<NoteDTO> listUnarchivedNote() {
        List<Note> savedUnarchivedNotes = repo.findByArchivedFalse();
        List<NoteDTO> readedUnarchivedNotes = new ArrayList<>();
        for(Note note:savedUnarchivedNotes){
            readedUnarchivedNotes.add(NoteDTO.toDTO(note));
        }
        return readedUnarchivedNotes;
    }
}
