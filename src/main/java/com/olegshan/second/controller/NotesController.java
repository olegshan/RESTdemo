package com.olegshan.second.controller;

import com.olegshan.second.model.Note;
import com.olegshan.second.model.User;
import com.olegshan.second.repository.NoteRepository;
import com.olegshan.second.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by olegshan on 11.09.2016.
 */
@RestController
@RequestMapping("{username}/notes")
public class NotesController {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping
    Collection<Note> readNotes(@PathVariable String username) {
        return noteRepository.findByUserUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNote(@PathVariable String username, @RequestBody Note note) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        note.setUser(user);
        noteRepository.save(note);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("Could not find user '" + username + "'.");
    }

}
