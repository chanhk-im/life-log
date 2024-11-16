package com.chanhk.lifelog.controller;

import com.chanhk.lifelog.dto.CreateRootNodeRequestDto;
import com.chanhk.lifelog.dto.NodeRequestDto;
import com.chanhk.lifelog.dto.NodeResponseDto;
import com.chanhk.lifelog.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/node")
public class NodeController {
    private final NodeService nodeService;

    @GetMapping("/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping
    public NodeResponseDto createNode(@RequestBody NodeRequestDto nodeDto) {
        System.out.println(21);
        return nodeService.createNode(nodeDto);
    }

    @PostMapping("/root")
    public NodeResponseDto createRootNode(@RequestBody CreateRootNodeRequestDto dto) { return nodeService.createRootNode(dto); }

    @GetMapping
    public List<NodeResponseDto> getAllNodes() {
        return nodeService.getAllNodes();
    }

    @GetMapping("/{nodeId}")
    public NodeResponseDto getNodeById(@PathVariable Long nodeId) {
        return nodeService.getNodeById(nodeId);
    }

    @DeleteMapping("/{nodeId}")
    public String deleteNode(@PathVariable Long nodeId) {
        return nodeService.deleteNode(nodeId);
    }
}
