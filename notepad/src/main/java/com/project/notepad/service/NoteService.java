package com.project.notepad.service;

import com.project.notepad.entity.Note;

import java.util.List;


public interface NoteService {

    Note createNote(Note note);

    Note getNoteById(Long id);

    List<Note> getAllNotes();

    Note updateNote(Note note);

    Note edit(Note note);

    void deleteNote(Long id);

    void deleteAllNote();
}
