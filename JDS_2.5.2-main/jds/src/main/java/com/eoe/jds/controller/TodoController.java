package com.eoe.jds.controller;

import com.eoe.jds.dto.ResponseDTO;
import com.eoe.jds.dto.TodoDTO;
import com.eoe.jds.entity.ToDo;
import com.eoe.jds.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final ToDoService toDoService;

    //데이터 삽입
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<?> CreateTodo(@RequestBody TodoDTO dto){
        try{
            //가상의 user-ID
            String temporaryUserId = "temporary-user";
            //실제로 사용시에는 여기다가 로그인된 아이디를 집어넣으면 됨

            //Entity 생성
            ToDo toDo = TodoDTO.toEntity(dto);
            //가상아이디를 사용자 아이디로 설정
            toDo.setUserId(temporaryUserId);

            // 데이터 생성
            List<ToDo> entity = toDoService.create(toDo);

            //ToDo -> ToDoDTO -> List
            List<TodoDTO> dtos = entity.stream().map(TodoDTO::new).collect(Collectors.toList());
            //:: 기준으로 왼쪽 객체의 오른쪽 메소드를 사용한다는 의미(객체에서 특정메소드를 호출하는 용도)

            //응답 객체 생성
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //ID 조회
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<?> RetrieveTodo(@RequestBody TodoDTO dto){
        String temporaryUserId = "temporary-user";

        // ID로 해당되는 게시물 목록 조회
        List<ToDo> entity = toDoService.retrieve(temporaryUserId);

        List<TodoDTO> dtos = entity.stream().map(TodoDTO::new).collect(Collectors.toList());
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
        //Client에게로 발송
        return ResponseEntity.ok().body(response);
    }

    //데이터 수정
    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public ResponseEntity<?> UpdateTodo(@RequestBody TodoDTO dto){
        try {
            String temporaryUserId = "temporary-user";
            ToDo toDo = TodoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            List<ToDo> entity = toDoService.update(toDo);
            List<TodoDTO> dtos = entity.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //데이터 삭제
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping
    public ResponseEntity<?> DeleteTodo(@RequestBody TodoDTO dto){
        try{
            String temporaryUserId = "temporary-user";
            ToDo toDo = TodoDTO.toEntity(dto);
            toDo.setUserId(temporaryUserId);

            List<ToDo> entity = toDoService.delete(toDo);
            List<TodoDTO> dtos = entity.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }

    }

}
