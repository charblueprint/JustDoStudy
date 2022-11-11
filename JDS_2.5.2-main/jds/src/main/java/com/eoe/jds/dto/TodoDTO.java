package com.eoe.jds.dto;

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

}
