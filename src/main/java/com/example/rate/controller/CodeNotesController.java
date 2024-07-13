package com.example.rate.controller;
import com.example.rate.models.CodeNote;
import com.example.rate.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/codeNotes")

public class CodeNotesController {
    @Autowired
    NoteService noteService;

    @GetMapping("/api/user")
    public Principal user(Principal principal) {
        return principal;
    }
    @PostMapping
    private ResponseEntity<Void> createNote (@RequestBody CodeNote newNote , UriComponentsBuilder ucb){
        CodeNote save = noteService.createNote(newNote);
        URI locationOfNewNote = ucb
                .path("codeNote/{id}")
                .buildAndExpand(save.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewNote)
                .build();
    }
    @GetMapping
    private ResponseEntity<List<CodeNote>> getAll (){
        if (noteService.getAllNotes().isEmpty())
                return ResponseEntity.noContent().build();
        return ResponseEntity.ok(noteService.getAllNotes());
    }
    @GetMapping("/{id}")
    private ResponseEntity<Optional<CodeNote>> getById (@PathVariable Long id){
        if (id.describeConstable().isEmpty())
            return ResponseEntity.noContent().build();
        if (noteService.getIdNote(id).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(noteService.getIdNote(id));
    }
    @GetMapping("/filter/{name}")
    private ResponseEntity<Optional<CodeNote>> getByName(@PathVariable String name){
        if (!name.isEmpty())
            return ResponseEntity.notFound().build();
        if (noteService.getNameNote(name).isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(noteService.getNameNote(name));
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteNote(@PathVariable Long id){
        try {
            noteService.deleteNote(id);
            return ResponseEntity.ok().body("Delete Successful");
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found codeNote" + id, ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed codeNote", ex);
        }
    }
    @PutMapping("/{id}")
    private ResponseEntity<CodeNote> updateNote(@PathVariable Long id, @RequestBody CodeNote codeNote){
        try {
            CodeNote updatedNote = noteService.updateCodeNote(id, codeNote);
            if (updatedNote == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.accepted().body(updatedNote);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found codeNote " + id, ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Update Failed codeNote", ex);
        }
    }
}
