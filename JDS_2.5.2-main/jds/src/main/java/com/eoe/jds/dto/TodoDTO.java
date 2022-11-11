package com.eoe.jds.dto;

import com.eoe.jds.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    private String id;
    private String title;
    private boolean done;

    //Entity -> DTO 인스턴스 생성
    public TodoDTO(final TodoDTO todoDTO){
        this.id = todoDTO.getId();
        this.title = todoDTO.getTitle();
        this.done = todoDTO.isDone();
    }

    //DTO 인스턴스 -> Entity 인스턴스
    public static ToDo toEntity(final TodoDTO dto){
        return ToDo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
