package com.notecreation.note.service;

import com.notecreation.note.dto.NoteDTO;

import java.util.List;

public interface INoteService {
    NoteDTO createNote(NoteDTO note);

    NoteDTO editNote(Integer id, NoteDTO note);

    NoteDTO deleteNote(Integer id);

    NoteDTO archiveNote(Integer id);


    NoteDTO unarchiveNote(Integer id);

    List<NoteDTO> listArchivedNote();

    List<NoteDTO> listUnarchivedNote();

    NoteDTO readOneNote(Integer id);
}
