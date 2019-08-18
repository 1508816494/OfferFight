package com.yyt;
import java.util.HashMap;
import java.util.Map;

public class Study4 {
    private final Map map;  //写成final只表明引用不变，map不指向其他map，其他引用可能和map指向同样

    public Study4(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name", "yyt");
        Study4 yyt = new Study4(map);
        Map temp = yyt.getMap();
        temp.put("age", "18");
        System.out.println(yyt.getMap());
    }
}
