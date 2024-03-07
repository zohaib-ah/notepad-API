package com.project.notepad.controller;


import com.project.notepad.entity.DeleteMessage;
import com.project.notepad.entity.Note;
import com.project.notepad.service.implementation.NoteServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/notes")
public class NoteController {


    NoteServiceImp noteServiceImp;
    DeleteMessage deleteMessage;


    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note){
        Note note2 = noteServiceImp.createNote(note);
        return new ResponseEntity<>(note2, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Note> NoteById(@PathVariable Long id){
        Note note = noteServiceImp.getNoteById(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteServiceImp.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id, @RequestBody Note note){
        note.setId(id);
        Note note1 = noteServiceImp.updateNote(note);
        return new ResponseEntity<>(note1, HttpStatus.OK);
    }


    @PatchMapping("{id}")
    public ResponseEntity<Note> editNote(@PathVariable Long id,@RequestBody Note note){
        note.setId(id);
        return new ResponseEntity<>(noteServiceImp.edit(note), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMessage> delete(@PathVariable long id){
        noteServiceImp.deleteNote(id);
        DeleteMessage deleteMessage1 = new DeleteMessage("Note has been deleted");
        return new ResponseEntity<>(deleteMessage1, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DeleteMessage> deleteAll(){
        noteServiceImp.deleteAllNote();
        DeleteMessage deleteMessage2 = new DeleteMessage("All notes have been deleted");
        return new ResponseEntity<>(deleteMessage2, HttpStatus.OK);
    }


}
