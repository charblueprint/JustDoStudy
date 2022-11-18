package com.eoe.jds.service;

import com.eoe.jds.entity.ToDo;
import com.eoe.jds.persistent.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {
        private final TodoRepository toDoRepository;

        public List<ToDo> getList(){
                return this.toDoRepository.findAll();
        }

        public void create(String title){
                String id = "temporary_id";
                ToDo toDo = new ToDo();
                toDo.setUserId(id);
                toDo.setTitle(title);
                toDo.setDone(false);
                this.toDoRepository.save(toDo);
        }
        public void delete(Integer id){

        }
}
