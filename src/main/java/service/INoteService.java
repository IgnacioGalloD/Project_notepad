package service;

import dto.NoteDTO;

import java.util.List;

public interface INoteService {
    NoteDTO createNote(NoteDTO note);

    NoteDTO editNote(Integer id, NoteDTO note);

    NoteDTO deleteNote(Integer id, NoteDTO note);

    NoteDTO archiveNote(Integer id, NoteDTO note);


    NoteDTO unarchiveNote(Integer id, NoteDTO note);

    List<NoteDTO> listArchivedNote();

    List<NoteDTO> listUnarchivedNote();
}
