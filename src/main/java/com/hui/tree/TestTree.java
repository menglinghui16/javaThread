package com.hui.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: menglh
 * @Description:
 * @Date: 2021/3/26 10:09
 */
public class TestTree {
    //生成树结构数据方法
    private static List<NodeTest> getTree(List<NodeTest> nodes) {
        Map<Long, NodeTest> nodeMap = new HashMap<>();//方便查找
        List<NodeTest> rootList = new ArrayList<>();//定义根节点，租后返回的也是根节点
        //根节点特点：parentId小于0
        for (NodeTest node : nodes) {//找出根节点，并且给nodemap赋值
            nodeMap.put(node.getId(), node);
            if (node.getParentId() == null || node.getParentId() <= 0) {
                rootList.add(node);
            }
        }

        for (NodeTest node : nodes) { //循环相对于根节点的所有子节点：循环除根节点外的其他节点；
            if (node.getParentId() == null || node.getParentId() <= 0) {
                continue;
            }
            NodeTest pNode = nodeMap.get(node.getParentId());//找出子节点对应的父节点，给父节点的children进行add该子节点；
            if (pNode == null) {
                continue;
            }
            List<NodeTest> children = pNode.getChildren();
            if (children == null) {//不加这个判断会报错； 对父节点中不存在children属性的，要进行set添加；
                children = new ArrayList<>();
                pNode.setChildren(children);
            }
            children.add(node);
        }
        return rootList;
    }

    public static void main(String[] args) {
        List<NodeTest> nodeTestList = new ArrayList<>();
        nodeTestList.add(new NodeTest(1L, "一级", -1L));
        nodeTestList.add(new NodeTest(2L, "一级-1", 1L));
        nodeTestList.add(new NodeTest(3L, "一级-1-1", 2L));
        nodeTestList.add(new NodeTest(4L, "二级", -1L));
        System.out.println(JSON.toJSONString(getTree(nodeTestList)));
    }

}
