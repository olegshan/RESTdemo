package com.olegshan.second;

import com.olegshan.second.model.Note;
import com.olegshan.second.model.User;
import com.olegshan.second.repository.NoteRepository;
import com.olegshan.second.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App {

    @Bean
    CommandLineRunner init(UserRepository userRepository, NoteRepository noteRepository) {
        return (evt) -> {
            User user = new User();
            user.setUsername("olegshan");
            user.setPassword("password");
            userRepository.save(user);

            Note note = new Note();
            note.setUser(user);
            note.setText("Text of the first note");
            noteRepository.save(note);

            user = new User();
            user.setUsername("Oleg");
            user.setPassword("password");
            userRepository.save(user);

            note = new Note();
            note.setUser(user);
            note.setText("Text of the second note");
            noteRepository.save(note);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
