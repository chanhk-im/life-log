package com.chanhk.lifelog.service;

import com.chanhk.lifelog.domain.Node;
import com.chanhk.lifelog.dto.CreateRootNodeRequestDto;
import com.chanhk.lifelog.dto.NodeRequestDto;
import com.chanhk.lifelog.dto.NodeResponseDto;
import com.chanhk.lifelog.exception.NodeNotFoundException;
import com.chanhk.lifelog.exception.ParentNodeNotFoundException;
import com.chanhk.lifelog.exception.RootNodeAlreadyExistException;
import com.chanhk.lifelog.exception.RootNodeDeletionException;
import com.chanhk.lifelog.repository.NodeRepository;
import com.chanhk.lifelog.util.Message;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NodeServiceImpl implements NodeService {
    private final NodeRepository nodeRepository;

    @Override
    @Transactional
    public NodeResponseDto createNode(NodeRequestDto dto) {
        System.out.println(dto.getParentId());
        Node parent = nodeRepository.findById(dto.getParentId()).orElseThrow(ParentNodeNotFoundException::new);
        Node node = dto.toEntity(parent);
        System.out.println(node.getId());
        nodeRepository.save(node);

        return new NodeResponseDto(node, dto.getParentId());
    }

    @Override
    @Transactional
    public NodeResponseDto createRootNode(CreateRootNodeRequestDto dto) {
        if (nodeRepository.existsByIsRoot(true)) {
            throw new RootNodeAlreadyExistException();
        }
        Node root = dto.toEntity();
        nodeRepository.save(root);

        return new NodeResponseDto(root, 0L);
    }

    @Override
    @Transactional
    public List<NodeResponseDto> getAllNodes() {
        List<NodeResponseDto> nodeList = new ArrayList<>();
        List<Node> nodes = nodeRepository.findAll();
        for (Node node: nodes) {
            Long parentId = node.getParent().getId();
            nodeList.add(new NodeResponseDto(node, parentId));
        }

        return nodeList;
    }

    @Override
    @Transactional
    public NodeResponseDto getNodeById(Long id) {
        Optional<Node> node = nodeRepository.findById(id);
        if (node.isEmpty()) {
            throw new NodeNotFoundException();
        }

        if (node.get().getParent() == null)
            return new NodeResponseDto(node.get(), 0L);
        return new NodeResponseDto(node.get(), node.get().getParent().getId());
    }

    @Override
    @Transactional
    public String deleteNode(Long id) {
        if (!nodeRepository.existsById(id)) {
            throw new NodeNotFoundException();
        }

        Optional<Node> node = nodeRepository.findById(id);
        if (node.isPresent() && node.get().getIsRoot().equals(true)) {
            throw new RootNodeDeletionException();
        }
        nodeRepository.deleteById(id);

        return Message.DELETION_SUCCESS;
    }
}
