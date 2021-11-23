package com.example.memo.domain;

import com.example.memo.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려준다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어준다.

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 한다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "memo", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
