package com.core.java.programs.practical;

public class MyCalls {

    public static void main(String[] args) {
        int i = 3;
        String s = "test1";
        VO vo = new VO();
        vo.i=9;
        vo.s="test2";
        changeMe(i, vo, s);
        System.out.println(i + "-" + s +"-" + vo.i + "-" + vo.s);
    }

    private static void changeMe(int i, VO vo1, String s) {
        i = ++i;
        s="test3";
        vo1.i=99;
        vo1.s = "test4";
    }
}

class VO{
    public String s;
    public int i;
}
