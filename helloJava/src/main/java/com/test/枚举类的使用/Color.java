package com.test.枚举类的使用;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/6/10 19:42
 * description: 枚举类的使用
 */

public enum Color{
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量  
    private String name;
    private int index;
    // 构造方法  
    private Color(String name, int index){
        this.name = name;
        this.index=index;
    }
    // 普通方法  
    public static String getName(int index) {
        for(Color c : Color.values()){
            if(c.getIndex()==index){
                return c.name;
            }
        }
        return null;
    }

    public static Integer getIndex(String name) {
        for(Color c : Color.values()){
            if(c.getName().equals(name)){
                return c.index;
            }
        }
        return null;
    }
    // get set 方法  
    public String getName() {
        return name;
    }
    public void setName(String name){
    this.name = name;
    }
    public int getIndex(){
    return index;
    }
    public void setIndex(int index){
    this.index = index;
}



}
