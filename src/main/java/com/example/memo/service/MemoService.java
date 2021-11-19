package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.dto.MemoRequestDto;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor   // 초기화 되지않은 final 필드의 생성자를 생성해야하므로 표시
@Service

public class MemoService {

    private final MemoRepository memoRepository;

    // create
    public Memo setMemo(MemoRequestDto memoRequestDto){
        Memo memo = new Memo(); // 저장하는 것은 DTO가 아닌, Memo이므로, DTO정보를 Memo에 담아야 하므로, Memo의 생성자 만들기
        memo.setTitle(memoRequestDto.getTitle());
        memo.setContent(memoRequestDto.getContent()); // memo 객체에 memoReqeustDto의 content 저장하기
        memoRepository.save(memo); // JPA를 이용해 DB에 저장하고, 결과를 return
        return memo;
    }

    // read
    public List<Memo> getAllMemos(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    public Memo getMemo(Long id){
        return memoRepository.findById(id).get();
    }

    // delete
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

}