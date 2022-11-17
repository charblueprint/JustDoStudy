package com.eoe.jds.controller;

import com.eoe.jds.entity.ToDo;
import com.eoe.jds.service.ToDoService;
import groovy.util.logging.Log4j;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    @GetMapping({"/todo/list"})
    public String list(){
        log.info("....list...");
        return "todo/list";
    }



}
