package com.project.notepad.repository;

import com.project.notepad.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;




public interface NoteRepository extends JpaRepository<Note, Long> {


}
