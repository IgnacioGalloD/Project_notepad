package com.notecreation.note.controller;

import com.notecreation.note.dto.NoteDTO;
import com.notecreation.note.exceptions.NoteNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.notecreation.note.service.INoteService;

@RestController
public class NoteController {
    @Autowired
    private INoteService service;

    //      CREATE NOTE

    @PostMapping(value="/createnote")
    public ResponseEntity<NoteDTO> createNote(@RequestBody @Valid NoteDTO note){
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }

    //      READ NOTE BY ID

    @GetMapping(value = "/readonenote/{id}")
    public ResponseEntity<NoteDTO> readOneNote(@PathVariable Integer id) throws NoteNotFoundException {
        return new ResponseEntity<>(service.readOneNote(id), HttpStatus.OK);
    }

    //      EDIT NOTE

    @PutMapping(value="/editnote/{id}")
    public ResponseEntity<?> editNote(@PathVariable Integer id, @RequestBody @Valid NoteDTO note) throws NoteNotFoundException{
        return new ResponseEntity<NoteDTO>(service.editNote(id, note), HttpStatus.OK);
    }

    //      DELETE NOTE

    @PutMapping(value = "/deletenote/{id}")
    public  ResponseEntity<?> deleteNote(@PathVariable Integer id) throws NoteNotFoundException{
        return new ResponseEntity<>(service.deleteNote(id), HttpStatus.OK);
    }

    //      ARCHIVE NOTE

    @PutMapping(value = "/archivenote/{id}")
    public ResponseEntity<?> archiveNote(@PathVariable Integer id) throws NoteNotFoundException{
        return new ResponseEntity<>(service.archiveNote(id), HttpStatus.OK);
    }

    //      UNARCHIVE NOTE

    @PutMapping(value = "/unarchivenote/{id}")
    public ResponseEntity<?> unarchiveNote(@PathVariable Integer id)throws NoteNotFoundException{
        return new ResponseEntity<>(service.unarchiveNote(id), HttpStatus.OK);
    }

    //      LIST ACTIVE NOTE

    @GetMapping(value = "/listarchivednote")
    public ResponseEntity<?> listArchivedNote(){
        return new ResponseEntity<>(service.listArchivedNote(), HttpStatus.OK);
    }

    //      LIST UNACTIVE NOTE

    @GetMapping(value = "/listunarchivednote")
    public ResponseEntity<?> listUnarchivedNote(){
        return new ResponseEntity<>(service.listUnarchivedNote(), HttpStatus.OK);
    }

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<String> handleDemoNotFoundException(NoteNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

}