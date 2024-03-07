package com.project.notepad.service.implementation;

import com.project.notepad.entity.Note;
import com.project.notepad.repository.NoteRepository;
import com.project.notepad.service.NoteService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
@AllArgsConstructor

public class NoteServiceImp implements NoteService {


    NoteRepository noteRepository;
    @Override
    public Note createNote(Note note) {
        try {
            return noteRepository.save(note);
        }catch (Exception e){
            throw new RuntimeException("Failed to create note " + e.getMessage());
        }
    }

    @Override
    public Note getNoteById(Long id) {
       try {
           Optional<Note> note = noteRepository.findById(id);
           return note.get();
       }catch (Exception e){
           throw new RuntimeException("Failed to get get note by id :"+ id +" " + e.getMessage());
       }
    }

    @Override
    public List<Note> getAllNotes() {
        try {
            return noteRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Failed to get all notes " + e.getMessage());
        }
    }

    @Override
    public Note updateNote(Note note) {

        try {
            Note updatenote = noteRepository.findById(note.getId()).get();
            updatenote.setTitle(note.getTitle());
            updatenote.setDescription(note.getDescription());
            Note savedNote = noteRepository.save(updatenote);
            return savedNote;
        }catch (Exception e){
            throw new RuntimeException("Failed to update note "+ e.getMessage());
        }

    }

    @Override
    public Note edit(Note note) {

        try {
            Note editNote = noteRepository.findById(note.getId()).orElseThrow(()-> new RuntimeException("note not found"));
           if(note.getTitle() != null && !note.getTitle().isEmpty()){
               editNote.setTitle(note.getTitle());
           }
           if (note.getDescription() != null && !note.getDescription().isEmpty()) {
               editNote.setDescription(note.getDescription());
           }
            return noteRepository.save(editNote);
        }catch (Exception e){
            throw new RuntimeException("Failed to edit note "+ e.getMessage());
        }
    }

    @Override
    public void deleteNote(Long id) {
        try {
            noteRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Failed to delete note by id: "+ id);
        }
    }

    @Override
    public void deleteAllNote() {
        try{
            noteRepository.deleteAll();
        }catch (Exception e){
            throw new RuntimeException("Failed to delete all notes " + e.getMessage());
        }
    }


}
