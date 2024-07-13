package com.example.rate.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Entity
@Table(name = "codeNotes")
@Getter
@Setter
public class CodeNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "code",nullable = false, length = 2000)
    private String code;
    @Column(name = "description", length = 500)
    private String description ;
    @Column(name = "dateRegister", nullable = false, updatable = false)
    private LocalDateTime dateRegister;
    @Column(name = "category", nullable = false)
    private char category;
    //Execute before create
    @PrePersist
    protected void onCreate() {
        dateRegister = LocalDateTime.now();
    }
}
