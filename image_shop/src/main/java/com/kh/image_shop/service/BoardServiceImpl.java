package com.kh.image_shop.service;

import com.kh.image_shop.domain.Board;
import com.kh.image_shop.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper mapper;

    @Override
    public void register(Board board) throws Exception {
        mapper.create(board);
    }
}
