package com.chanhk.lifelog.dto;

import com.chanhk.lifelog.domain.Node;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NodeRequestDto {
    private String title;
    private String content;
    private Long parentId;

    public Node toEntity(Node parent) {
        return Node.builder().title(title).content(content).parent(parent).isRoot(false).build();
    }
}
