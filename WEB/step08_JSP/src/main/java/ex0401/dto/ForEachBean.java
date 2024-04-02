package ex0401.dto;

import java.util.*;

//Bean == Class 1개
public class ForEachBean {
    private String names[] = {"a","b","c","d","e"};
    private List<String> menus = Arrays.asList("짜장","짬뽕","탕수육","잡채밥","팔보채","군만두");
    private List<Board> boardList = new ArrayList<Board>();
    private Map<String,String> map = new HashMap<String,String>();

    public String[] getNames() {
        return names;
    }

    public List<String> getMenus() {
        return menus;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public ForEachBean(){
        System.out.println("ForEachBean Constructor call");

//        boardList 데이터 초기화
        boardList.add(new Board(1,"title1","content1"));
        boardList.add(new Board(2,"title2","content2"));
        boardList.add(new Board(3,"title3","content3"));
        boardList.add(new Board(4,"title4","content4"));
        boardList.add(new Board(5,"title5","content5"));
        boardList.add(new Board(6,"title6","content6"));
        boardList.add(new Board(7,"title7","content7"));
        boardList.add(new Board(8,"title8","content8"));

//        map 데이터 초기화
        map.put("kr","대한민국");
        map.put("us","미국");
        map.put("fr","프랑스");
        map.put("jp","일본");
        map.put("eu","유럽");
    }
}
