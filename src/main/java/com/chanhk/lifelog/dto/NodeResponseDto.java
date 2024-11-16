package com.chanhk.lifelog.dto;

import com.chanhk.lifelog.domain.Node;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NodeResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long parentId;

    @Builder
    public NodeResponseDto(Node node, Long parentId) {
        id = node.getId();
        title = node.getTitle();
        content = node.getContent();
        this.parentId = parentId;
    }
}
