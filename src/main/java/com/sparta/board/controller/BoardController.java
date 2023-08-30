package com.sparta.board.controller;
import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.service.BoardService;
import com.sparta.board.entity.Board;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
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
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }
    @DeleteMapping("/post/{id}")
    public BoardResponseDto deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.deleteBoard(id, requestDto);
    }
}