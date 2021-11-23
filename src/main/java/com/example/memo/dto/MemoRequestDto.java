package com.example.memo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemoRequestDto {
    private String title;
    private String content;
}

// 데이터(ex. 객체)를 주고 받을 때, 기존 클래스를 사용하는 것이 아니라, 새로운 클래스를 사용하자. -> DTO
// Why? 기존 클래스는 DB와 연결되어 오류가 날 가능성이 크기 때문이다.
//      또한, 기존 클래스를 통해 외부 사용자에게 데이터베이스의 스키마 형태, 데이터베이스의 구조, 서비스 내부 로직을 유출 될 수 있기 때문이다.
