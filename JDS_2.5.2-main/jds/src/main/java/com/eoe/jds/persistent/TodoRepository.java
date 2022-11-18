package com.eoe.jds.persistent;

import com.eoe.jds.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo,Integer>{
}