package com.mallapi.controller;

import com.mallapi.dto.PageRequestDTO;
import com.mallapi.dto.PageResponseDTO;
import com.mallapi.dto.TodoDTO;
import com.mallapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable(name = "tno") Long tno) {
        return service.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        return service.list(pageRequestDTO);
    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDTO todoDTO) {
        log.info("todoDTO: {}", todoDTO);
        Long tno = service.register(todoDTO);
        return Map.of("tno", tno);
    }

    @PutMapping("/{tno}")
    public Map<String, String> modify(@PathVariable Long tno, @RequestBody TodoDTO todoDTO) {
        todoDTO.setTno(tno);
        log.info("todoDTO: {}", todoDTO);
        service.modify(todoDTO);
        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove( @PathVariable(name="tno") Long tno ){
        log.info("Remove: " + tno);
        service.delete(tno);
        return Map.of("RESULT", "SUCCESS");
    }

}
