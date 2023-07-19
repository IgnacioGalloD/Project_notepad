package com.notecreation.note.dto;

import com.notecreation.note.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NoteDTO {
    private Integer id;
    private String title;
    private String content;
    private boolean archived;
    private boolean deleted;

    public static NoteDTO toDTO(Note entity){
        NoteDTO dto = new NoteDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setArchived(entity.isArchived());
        dto.setDeleted(entity.isDeleted());
        return dto;
    }

    public static Note toEntity(NoteDTO dto){
        Note entity = new Note();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setArchived(dto.isArchived());
        entity.setDeleted(dto.isDeleted());
        return entity;
    }
}