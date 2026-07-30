package org.sc.security.impl;

import org.sc.security.Repository.NotesRepository;
import org.sc.security.model.Note;
import org.sc.security.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NoteService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Note createNoteForUser(String username, String content) {
        Note note=new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        return notesRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(Long id, String username, String content) {
       Note note= notesRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Notes not found"));
        note.setContent(content);
       return notesRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(Long id, String username) {
        notesRepository.deleteById(id);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
        List<Note> personalNotes=notesRepository.findByOwnerUsername(username);
        return personalNotes;
    }
}
