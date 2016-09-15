package com.olegshan.second.repository;

import com.olegshan.second.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by olegshan on 11.09.2016.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    Collection<Note> findByUserUsername(String username);
}
