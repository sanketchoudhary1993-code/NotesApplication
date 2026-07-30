package org.sc.security.Repository;
import org.sc.security.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  NotesRepository extends JpaRepository <Note, Long>{
    List<Note> findByOwnerUsername(String ownerUsername);
}

