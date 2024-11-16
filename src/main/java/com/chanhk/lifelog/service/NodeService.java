package com.chanhk.lifelog.service;

import com.chanhk.lifelog.dto.CreateRootNodeRequestDto;
import com.chanhk.lifelog.dto.NodeRequestDto;
import com.chanhk.lifelog.dto.NodeResponseDto;

import java.util.List;

public interface NodeService {
    NodeResponseDto createNode(NodeRequestDto dto);
    NodeResponseDto createRootNode(CreateRootNodeRequestDto dto);
    List<NodeResponseDto> getAllNodes();
    NodeResponseDto getNodeById(Long id);
    String deleteNode(Long id);
}
