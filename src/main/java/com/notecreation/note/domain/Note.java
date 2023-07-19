package com.notecreation.note.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "notepad")
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column @NotBlank @NotNull @Size(max = 255)
    private String title;
    @Column @NotBlank @NotNull @Size(max = 255)
    private String content;
    @Column
    private boolean archived; // 0=no 1=yes
    @Column
    private boolean deleted; // 0=no 1=yes
}
