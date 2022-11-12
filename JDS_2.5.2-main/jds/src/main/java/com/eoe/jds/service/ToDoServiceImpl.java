package com.eoe.jds.service;

import com.eoe.jds.entity.ToDo;
import com.eoe.jds.persistent.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    //@autoweired가 어디에 선언될 수 있는지 service 계층에도 사용이 가능한지 찾아 볼 것
    private final TodoRepository toDoRepository;

    //유효성 검사 메솓
    private void validate(final ToDo toDo){
        if(toDo == null){
            throw  new RuntimeException("ToDo cannot be null");
        }
        if(toDo.getUserId() == null){
            throw  new RuntimeException("UserId cannot be null");
        }
    }

    @Override
    public List<ToDo> create(ToDo toDo) {
        //들어온 할일 목록을 유효성 검사 실행 문제가 없을 경우 통과 -> 문제 존재시 예외 처리
        validate(toDo);

        //데이터 추가
        toDoRepository.save(toDo);

        //데이터 자신의 제이터 목록을 반환
        return toDoRepository.findByuserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> retrieve(String userId) {
        return toDoRepository.findByuserId(userId);
    }

    @Override
    public List<ToDo> update(ToDo toDo) {
        validate(toDo);
        toDoRepository.save(toDo);
    return toDoRepository.findByuserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> delete(ToDo toDo) {
        validate(toDo);
        toDoRepository.delete(toDo);
        return toDoRepository.findByuserId(toDo.getUserId());
    }
}
