package com.chanhk.lifelog.dto;

import com.chanhk.lifelog.domain.Node;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRootNodeRequestDto {
    private String title;
    private String content;

    public Node toEntity() {
        return Node.builder().title(title).content(content).parent(null).isRoot(true).build();
    }
}
