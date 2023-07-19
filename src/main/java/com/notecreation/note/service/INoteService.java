package com.notecreation.note.service;

import com.notecreation.note.dto.NoteDTO;
import com.notecreation.note.exceptions.NoteNotFoundException;

import java.util.List;

public interface INoteService {
    NoteDTO createNote(NoteDTO note);

    NoteDTO editNote(Integer id, NoteDTO note) throws NoteNotFoundException;

    NoteDTO deleteNote(Integer id) throws NoteNotFoundException;

    NoteDTO archiveNote(Integer id) throws NoteNotFoundException;


    NoteDTO unarchiveNote(Integer id) throws NoteNotFoundException;

    List<NoteDTO> listArchivedNote();

    List<NoteDTO> listUnarchivedNote();

    NoteDTO readOneNote(Integer id) throws NoteNotFoundException;
}
