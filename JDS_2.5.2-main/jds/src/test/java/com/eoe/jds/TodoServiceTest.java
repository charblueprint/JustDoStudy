package com.eoe.jds;

import com.eoe.jds.entity.ToDo;
import com.eoe.jds.service.ToDoService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TodoServiceTest {
    @Autowired
    private ToDoService toDoService;

    //데이터 삽입 테스트
    //@Test
    @Disabled
    public void InsertServiceTest(){
        ToDo todo = ToDo.builder()
                .userId("yurim")
                .title("test")
                .done(true)
                .build();
        List<ToDo> list = toDoService.create(todo);
        System.out.println(list);
    }

    //데이터 조회 테스트
    //@Test
    @Disabled
    public void RetrieveServiceTest(){
        List<ToDo> list = toDoService.retrieve("yurim");
        System.out.print(list);
    }

    //데이터 수정 테스트
    //@Test
    @Disabled
    public void UpdateServiceTest(){
        ToDo todo = ToDo.builder()
                .id("402809818465678e01846567991e0001")
                .userId("yurim")
                .title("test030")
                .done(true)
                .build();
        List<ToDo> list = toDoService.update(todo);
    }


}
