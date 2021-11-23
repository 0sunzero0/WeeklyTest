package com.example.memo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.memo.dto.MemoCommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="memo_idx", nullable = false)
    private Memo memo;

    public Comment(MemoCommentRequestDto requestDto, Memo memo) {
        this.comment = requestDto.getComment();
        this.memo = memo;
    }

}
