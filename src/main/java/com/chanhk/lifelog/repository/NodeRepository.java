package com.chanhk.lifelog.repository;

import com.chanhk.lifelog.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NodeRepository extends JpaRepository<Node, Long> {
    Optional<Node> findByIsRoot(boolean isRoot); // 루트 노드 조회
    boolean existsByIsRoot(boolean isRoot);      // 루트 노드 존재 여부 확인
}
