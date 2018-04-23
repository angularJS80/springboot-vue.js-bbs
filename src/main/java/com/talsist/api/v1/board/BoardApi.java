package com.talsist.api.v1.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talsist.dto.BoardDto;
import com.talsist.dto.PaginationDto;
import com.talsist.service.BoardService;

@RestController
@RequestMapping("/api/v1/board")
public class BoardApi {

    private BoardService boardSvc;

    public BoardApi(BoardService boardSvc) {
        this.boardSvc = boardSvc;
    }

    @GetMapping("/")
    public Page<BoardDto> list(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            PaginationDto pagination) {
        Page<BoardDto> list = boardSvc.findAll(pageable, pagination);
        pagination.calcPage(list, 5);
        return list;
    }

    @PostMapping("/")
    public String write() {
        return null;
    }

    @GetMapping("/{id}")
    public String readOne() {
        return "hello";
    }

    @PutMapping("/{id}")
    public String modifyOne() {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteOne() {
        return null;
    }

}
