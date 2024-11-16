package com.chanhk.lifelog.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nodes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Node parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Node> children = new ArrayList<>();

    @Column(nullable = false)
    private Boolean isRoot;

    @Builder
    public Node(String title, String content, Node parent, Boolean isRoot) {
        this.title = title;
        this.content = content;
        this.parent = parent;
        this.isRoot = isRoot;
    }
}
