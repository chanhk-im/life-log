package com.chanhk.lifelog;

import com.chanhk.lifelog.domain.Node;
import com.chanhk.lifelog.repository.NodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class NodeRepositoryTest {
    @Autowired
    private NodeRepository nodeRepository;

    @Test
    public void testFindByIsRoot() {
        if (nodeRepository.existsByIsRoot(true)) {
            Optional<Node> fetchedNode = nodeRepository.findByIsRoot(true);

            assertTrue(fetchedNode.isPresent());
            assertEquals(true, fetchedNode.get().getIsRoot());
        } else {
            Node root = Node.builder().title("Root").content("root content").isRoot(true).build();
            nodeRepository.save(root);

            Optional<Node> fetchedNode = nodeRepository.findByIsRoot(true);

            assertTrue(fetchedNode.isPresent());
            assertEquals("Root", fetchedNode.get().getTitle());
            assertEquals(true, fetchedNode.get().getIsRoot());

            nodeRepository.delete(fetchedNode.get());
        }

    }
}
