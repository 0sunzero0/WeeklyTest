package com.example.memo.controller;

import com.example.memo.domain.Memo;
import com.example.memo.dto.MemoRequestDto;
import com.example.memo.repository.MemoRepository;
import com.example.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //  초기화 되지않은 final 필드의 생성자를 생성해야하므로 표시
@RestController //  Json 형태로 객체 데이터를 return 해야하므로 표시
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // create
    @PostMapping("/memo")
    public Memo setMemo(@RequestBody MemoRequestDto memoRequestDto) {
        return memoService.setMemo(memoRequestDto);
    }

    @GetMapping("/memo/{id}")
    public Memo getMemo(@PathVariable Long id){
        return memoService.getMemo(id);
    }
}