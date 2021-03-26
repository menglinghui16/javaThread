package com.hui.tree;

import lombok.Data;

import java.util.List;

/**
 * @Author: menglh
 * @Description:
 * @Date: 2021/3/26 10:02
 */
@Data
public class NodeTest {
    private Long id;
    private String name;
    private Long parentId;
    private List<NodeTest> children;

    public NodeTest(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
