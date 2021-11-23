package com.example.memo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemoCommentRequestDto {
    private Long idx;
    private String comment;
}
