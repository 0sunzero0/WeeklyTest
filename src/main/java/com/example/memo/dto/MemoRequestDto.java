package com.example.memo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemoRequestDto {
    private String title;
    private String content;
}