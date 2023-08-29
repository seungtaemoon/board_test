package com.sparta.board.controller;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;
    public BoardController(BoardService memoService) {
        this.boardService = memoService;
    }
    @PostMapping("/post")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }
    @GetMapping("/posts")
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }
    @GetMapping("/post/{id}")
    public List<BoardResponseDto> getBoardsByKeyword(String keyword) {
        return boardService.getBoardsByKeyword(keyword);
    }
    @PutMapping("/post/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }
    @DeleteMapping("/post/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}