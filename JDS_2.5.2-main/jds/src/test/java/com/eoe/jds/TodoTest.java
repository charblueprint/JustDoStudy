package com.eoe.jds;

import com.eoe.jds.entity.ToDo;
import com.eoe.jds.persistent.TodoRepository;
import com.sun.xml.bind.v2.TODO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class TodoTest {
    @Autowired
    private TodoRepository todoRepository;

    //데이터 삽입 테스트
    //@Test
    @Disabled
    public void insertTest(){
        //300 개의 가상의 데이터 삽입
        IntStream.rangeClosed(1, 5).forEach(i -> {
            ToDo todo1 = ToDo.builder()
                    .userId("yurim")
                    .title("서점가기"+i)
                    .build();
            todoRepository.save(todo1);
        });
    }

    //유저 아이디 조회 테스트
    //@Test
    @Disabled
    public void FindByUserIdTest(){
        StringBuilder sb = new StringBuilder();
        List<ToDo> list = todoRepository.findByuserId("yurim");
        /* for(ToDo toDo: list){
            System.out.println(toDo);
        } */
        list.stream().forEach(toDo -> {
            sb.append(toDo).append("\n");
        });
        System.out.print(sb);
    }

    //id에 해당하는 하나의 데이터 조회 테스트
    //@Test
    @Disabled
    public void DetailTest(){
        Optional<ToDo> result = todoRepository.findById("40280981846520ce01846520da8d0000");
        if(result.isPresent()) System.out.println(result.get());
        else { System.out.println("데이터가 존재하지 않습니다."); }
    }

    // 데이터 수정 테스트
    //@Test
    @Disabled
    public void UpdateTest(){
        ToDo update1 = ToDo.builder()
                .id("40280981846520ce01846520da8d0000")
                .userId("유림")
                .title("친구만나서 운동하기 do exercise")
                .done(true)
                .build();
        todoRepository.save(update1);
    }

    // 데이터 삭제 테스트
    //@Test
    @Disabled
    public void DeleteTest(){
        todoRepository.deleteById("40280981846520ce01846520da8d0000");
    }
}
