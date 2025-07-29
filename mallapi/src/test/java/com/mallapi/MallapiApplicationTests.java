package com.mallapi;

import com.mallapi.domain.Todo;
import com.mallapi.repository.TodoRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@Log4j2
@SpringBootTest
class MallapiApplicationTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public  void test1() {
        log.info("-----------------------");
        log.info("test1");
        log.info("todoRepository");
    }

    @Test
    public void testInsert() {
        for (int i = 0; i <= 100; i++) {
            Todo todo = Todo.builder()
                    .title("Title..." + i)
                    .dueDate(LocalDate.of(2025,07,25))
                    .writer("user00")
                    .build();
            todoRepository.save(todo);
        }
    }

    @Test
    public void testRead() {
        Long tno = 33L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();
        log.info(todo);
    }

    @Test
    public void testModify() {
        Long tno = 33L;
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();
        todo.changeTitle("Modify Title..." + tno);
        todo.changeDueDate(LocalDate.of(2025,07,24));
        todo.changeComplete(false);
        todoRepository.save(todo);
    }
    
    @Test
    public void testDelete() {
        Long tno = 33L;
    }
    
}
