package com.eoe.jds.persistent;

import com.eoe.jds.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo,String>, QuerydslPredicateExecutor<ToDo> {
    //userId를 가지고 조회하는 메서드
    public List<ToDo> findByuserId(String userId);
    public List<ToDo> findAll();
}