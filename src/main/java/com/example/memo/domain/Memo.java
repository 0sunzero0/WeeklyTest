package com.example.memo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려준다.
public class Memo {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 한다.
    @Column(nullable = false)
    private String content;
}