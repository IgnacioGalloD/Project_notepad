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
        Note editedNote = repo.findById(id).orElseThrow(() -> new IllegalStateException("Wrong user ID"+id));
        editedNote.setTitle(note.getTitle());
        editedNote.setContent(note.getContent());
        Note savedNote = repo.save(editedNote);
        return NoteDTO.toDTO(savedNote);
    }

    @Override
    public NoteDTO deleteNote(Integer id) {
        Note deletedNote = repo.findById(id).orElseThrow(() -> new IllegalStateException("Wrong user ID"+id));
        deletedNote.setDeleted(true);
        Note savedNote = repo.save(deletedNote);
        return NoteDTO.toDTO(savedNote);
    }

    @Override
    public NoteDTO archiveNote(Integer id) {
        Note archivedNote = repo.findById(id).orElseThrow(() -> new IllegalStateException("Wrong user ID"+id));
        archivedNote.setArchived(true);
        Note savedNote = repo.save(archivedNote);
        return NoteDTO.toDTO(savedNote);
    }

    @Override
    public NoteDTO unarchiveNote(Integer id) {
        Note unarchivedNote = repo.findById(id).orElseThrow(() -> new IllegalStateException("Wrong user ID"+id));
        unarchivedNote.setArchived(false);
        Note savedNote = repo.save(unarchivedNote);
        return NoteDTO.toDTO(savedNote);
    }

    @Override
    public List<NoteDTO> listArchivedNote() {
        List<Note> savedArchivedNotes = repo.findByArchivedTrueAndDeletedFalse();
        List<NoteDTO> readedArchivedNotes = new ArrayList<>();
        for(Note note:savedArchivedNotes){
            readedArchivedNotes.add(NoteDTO.toDTO(note));
        }
        return readedArchivedNotes;
    }

    @Override
    public List<NoteDTO> listUnarchivedNote() {
        List<Note> savedUnarchivedNotes = repo.findByArchivedFalseAndDeletedFalse();
        List<NoteDTO> readedUnarchivedNotes = new ArrayList<>();
        for(Note note:savedUnarchivedNotes){
            readedUnarchivedNotes.add(NoteDTO.toDTO(note));
        }
        return readedUnarchivedNotes;
    }

    @Override
    public NoteDTO readOneNote(Integer id) {
        Note savedNote = repo.findById(id).orElseThrow(() -> new IllegalStateException("Wrong user ID: "+id));
        return NoteDTO.toDTO(savedNote);
    }
}