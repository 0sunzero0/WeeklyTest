package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.domain.Comment;
import com.example.memo.dto.MemoCommentRequestDto;
import com.example.memo.dto.MemoRequestDto;
import com.example.memo.repository.MemoRepository;
import com.example.memo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor   // 초기화 되지않은 final 필드의 생성자를 생성해야하므로 표시
@Service

public class MemoService {

    private final MemoRepository memoRepository;
    private final CommentRepository commentRepository;

    // create memo
    public Memo setMemo(MemoRequestDto memoRequestDto){
        Memo memo = new Memo(); // 저장하는 것은 DTO가 아닌, Memo이므로, DTO정보를 Memo에 담아야 하므로, Memo의 생성자 만들기
        memo.setTitle(memoRequestDto.getTitle());
        memo.setContent(memoRequestDto.getContent()); // memo 객체에 memoReqeustDto의 content 저장하기
        memoRepository.save(memo); // JPA를 이용해 DB에 저장하고, 결과를 return
        return memo;
    }

    // read all memos
    public List<Memo> getAllMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    // read memo
    public Memo getMemo(Long id){
        return memoRepository.findById(id).get();
    }

    // delete memo
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

    // update memo
    @Transactional
    public void update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
    }

    // create comment
    @Transactional
    public void setMemoComment(MemoCommentRequestDto memoCommentRequestDto){
        Memo memo = memoRepository.findById(memoCommentRequestDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        Comment comment = new Comment(memoCommentRequestDto, memo);
        commentRepository.save(comment);
    }

}
