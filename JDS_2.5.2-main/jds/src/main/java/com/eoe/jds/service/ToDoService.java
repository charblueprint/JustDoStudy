package com.eoe.jds.service;

import com.eoe.jds.entity.ToDo;

import java.util.List;

public interface ToDoService {
    //데이터 삽입
    //주의 : ToDo를 받을 거라면 수정이 불가능하도록 final로 설정해야 함
    public List<ToDo> create(final ToDo toDo);

    //UserId를 이용한 조회
    public List<ToDo> retrieve(final String userId);

    //데이터 수정
    public List<ToDo> update(final ToDo toDo);

    //데이터 삭제
    public List<ToDo> delete(final ToDo toDo);
}
