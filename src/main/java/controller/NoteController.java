package controller;

import dto.NoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.INoteService;

@RestController
public class NoteController {
    @Autowired
    private INoteService service;

    //      CREATE NOTE
    @PostMapping(value="/createnote")
    public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO note){
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }

    //      EDIT NOTE
    @PutMapping(value="/editnote/{id}")
    public ResponseEntity<?> editNote(@PathVariable Integer id, @RequestBody NoteDTO note){
        return new ResponseEntity<>(service.editNote(id, note), HttpStatus.OK);
    }

    //      DELETE NOTE
    @PutMapping(value = "/deletenote/{id}")
    public  ResponseEntity<?> deleteNote(@PathVariable Integer id, @RequestBody NoteDTO note){
        return new ResponseEntity<>(service.deleteNote(id, note), HttpStatus.OK);
    }

    //      ARCHIVE NOTE
    @PutMapping(value = "/archivenote/{id}")
    public ResponseEntity<?> archiveNote(@PathVariable Integer id, @RequestBody NoteDTO note){
        return new ResponseEntity<>(service.archiveNote(id, note), HttpStatus.OK);
    }

    //      UNARCHIVE NOTE
    @PutMapping(value = "/unarchivenote/{id}")
    public ResponseEntity<?> unarchiveNote(@PathVariable Integer id, @RequestBody NoteDTO note){
        return new ResponseEntity<>(service.unarchiveNote(id,note), HttpStatus.OK);
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
}