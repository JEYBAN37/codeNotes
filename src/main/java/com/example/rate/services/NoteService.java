package com.example.rate.services;
import com.example.rate.models.CodeNote;
import com.example.rate.repository.CodeNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class NoteService {
    @Autowired
    private CodeNoteRepository codeNoteRepository;

    //Create Notes
    @Transactional
    public CodeNote createNote (CodeNote codeNote ){
        return codeNoteRepository.save(codeNote);
    }

    //Get Notes
    public List<CodeNote> getAllNotes (){
        return  codeNoteRepository.findAll();
    }

    //Get ById
    public Optional<CodeNote> getIdNote (Long id){
        return codeNoteRepository.findById(id);
    }

    public  Optional<CodeNote> getNameNote (String name){
        return codeNoteRepository.findByName(name);
    }

    //Delete CodeNote
    @Transactional
    public void deleteNote (Long id){
        codeNoteRepository.deleteById(id);
    }

    //update
    @Transactional
    public CodeNote updateCodeNote (Long id, CodeNote updateData){
        Optional<CodeNote> codeNote = codeNoteRepository.findById(id);
        if(codeNote.isPresent()){
            CodeNote existingObject = codeNote.get();
            existingObject.setName(updateData.getName());
            existingObject.setCode(updateData.getCode());
            return codeNoteRepository.save(existingObject);
        }
        return null;
    }
}
