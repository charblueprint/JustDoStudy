package com.eoe.jds.persistent;

import com.eoe.jds.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo,String> {
    //userId를 가지고 조회하는 메서드
    public List<ToDo> findByuserId(String userId);
}