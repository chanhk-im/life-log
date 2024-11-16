package com.chanhk.lifelog.dto;

import com.chanhk.lifelog.domain.Node;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateNodeRequestDto {
    private Long id;
    private String title;
    private String content;
}
