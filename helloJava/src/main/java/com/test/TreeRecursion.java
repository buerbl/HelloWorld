package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boolean
 * Date: 2019/5/27 10:04
 * description:
 */
public class TreeRecursion {
    public static void main(String[] args) {

        Map<String,Node> nodes = new HashMap<>();
        //模拟数据库存储树结构
        nodes.put("1",new Node("1","root",1,"0"));
        nodes.put("2",new Node("2","a",1,"1"));
        nodes.put("3",new Node("3","HasmMapTest",1,"1"));
        nodes.put("4",new Node("4","c",1,"1"));
        nodes.put("5",new Node("5","d",1,"2"));
        nodes.put("6",new Node("6","e",1,"2"));
        nodes.put("7",new Node("7","f",1,"3"));
        nodes.put("8",new Node("8","g",1,"7"));
        System.out.println("result:" + JSON.toJSONString(getNodeJson("0",nodes)));
    }

    /**
     * 递归处理   数据库树结构数据->树形json
     * @param nodeId
     * @param nodes
     * @return
     */
    public static JSONArray getNodeJson(String nodeId, Map<String,Node> nodes){

        //当前层级当前node对象
        Node cur = nodes.get(nodeId);
        //当前层级当前点下的所有子节点（实战中不要慢慢去查,一次加载到集合然后慢慢处理）
        List<Node> childList = getChildNodes(nodeId,nodes);

        JSONArray childTree = new JSONArray();
        for (Node node : childList) {
            JSONObject o = new JSONObject();
            o.put("name", node.getName());
            o.put("type", node.getType());
            JSONArray childs = getNodeJson(node.getId(),nodes);  //递归调用该方法
            if(!childs.isEmpty()) {
                o.put("children",childs);
            }
//            childTree.fluentAdd(o);
        }
        return childTree;
    }

    /**
     * 获取当前节点的所有子节点
     * @param nodeId
     * @param nodes
     * @return
     */
    public static List<Node> getChildNodes(String nodeId, Map<String,Node> nodes){
        List<Node> list = new ArrayList<>();
        for (String key : nodes.keySet() ) {
            if(nodes.get(key).getParentId().equals(nodeId)){
                list.add(nodes.get(key));
            }
        }
        return list;
    }

}


class Node{
    public String id ;
    public String name;
    public Integer type;
    public String parentId;

    public Node(String id, String name, Integer type, String parentId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
