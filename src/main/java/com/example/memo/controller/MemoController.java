package com.example.memo.controller;

import com.example.memo.domain.Memo;
import com.example.memo.dto.MemoCommentRequestDto;
import com.example.memo.dto.MemoRequestDto;
import com.example.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //  초기화 되지않은 final 필드의 생성자를 생성해야하므로 표시
@RestController //  Json 형태로 객체 데이터를 return 해야하므로 표시
public class MemoController {

    private final MemoService memoService;

    // create memo
    @PostMapping("/memo")
    public Memo setMemo(@RequestBody MemoRequestDto memoRequestDto) {
        return memoService.setMemo(memoRequestDto);
    }

    // read memo
    @GetMapping("/memos")
    public List<Memo> getAllMemos() {
        return memoService.getAllMemos();
    }

    @GetMapping("/memo/{id}")
    public Memo getMemo(@PathVariable Long id){
        return memoService.getMemo(id);
    }

    // delete memo
    @DeleteMapping("/memo/{id}")
    public void deleteMemo(@PathVariable Long id){
        memoService.deleteMemo(id);
    }

    // update memo
    @PutMapping("/memo/{id}")
    public void updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id, requestDto);
    }

    // create comment
    @PostMapping("/memo/comment")
    public void setMemoComment(@RequestBody MemoCommentRequestDto memoCommentRequestDto){
        memoService.setMemoComment(memoCommentRequestDto);
    }
}
