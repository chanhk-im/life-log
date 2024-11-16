package com.chanhk.lifelog.service;

import com.chanhk.lifelog.dto.CreateRootNodeRequestDto;
import com.chanhk.lifelog.dto.CreateNodeRequestDto;
import com.chanhk.lifelog.dto.NodeResponseDto;
import com.chanhk.lifelog.dto.UpdateNodeRequestDto;

import java.util.List;

public interface NodeService {
    NodeResponseDto createNode(CreateNodeRequestDto dto);
    NodeResponseDto createRootNode(CreateRootNodeRequestDto dto);
    List<NodeResponseDto> getAllNodes();
    NodeResponseDto getNodeById(Long id);
    NodeResponseDto updateNode(UpdateNodeRequestDto dto);
    String deleteNode(Long id);
}
