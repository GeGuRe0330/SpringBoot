package com.mallapi.repository;

import com.mallapi.domain.Todo;
import com.mallapi.dto.PageRequestDTO;
import com.mallapi.dto.PageResponseDTO;
import com.mallapi.dto.TodoDTO;
import com.mallapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info(result.getTotalElements());

        result.getContent().stream().forEach(todo -> log.info(todo));
    }

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("서비스 테스트")
                .writer("tester")
                .dueDate(LocalDate.of(2025,07,29))
                .build();
        Long tno = todoService.register(todoDTO);
        log.info("TNO : " + tno);
    }

    @Test
    public void testGet() {
        Long tno = 101L;
        TodoDTO todoDTO = todoService.get(tno);
        log.info(todoDTO);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);
        log.info(response);
        log.info("SUCCESS");
    }

}
