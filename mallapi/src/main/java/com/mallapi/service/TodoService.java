package com.mallapi.service;

import com.mallapi.dto.PageRequestDTO;
import com.mallapi.dto.PageResponseDTO;
import com.mallapi.dto.TodoDTO;

public interface TodoService {
    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);

    void modify(TodoDTO todoDTO);

    void delete(Long tno);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
