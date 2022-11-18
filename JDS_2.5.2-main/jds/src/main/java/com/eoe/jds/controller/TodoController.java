package com.eoe.jds.controller;

import com.eoe.jds.entity.ToDo;
import com.eoe.jds.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class TodoController {

   private final ToDoService toDoService;

   @GetMapping("/todo")
   public String list(Model model){
       List<ToDo> toDoList = this.toDoService.getList();
       log.info("....list...");
       model.addAttribute("todoList",toDoList);
       return "todo/list";
   }
    // url 설정은 /todo/create
    @PostMapping("/todo/create/{user_id}")
    public String todoCreate(@RequestParam String title){
        //Todo : 아이템 삽입
        this.toDoService.create(title);
        // 다시 원래 화면으로 리다이렉트
        return "redirect:/todo";
    }
    @DeleteMapping("/todo/delete/{id}")
    public String todoDelete(@PathVariable Integer id){
        this.toDoService.delete(id);
        return "redirect:/todo";
    }


}
