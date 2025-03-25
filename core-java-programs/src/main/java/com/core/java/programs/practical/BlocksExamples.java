package com.core.java.programs.practical;

import com.core.java.programs.Test;

public class BlocksExamples {
    static int i;
    static Integer j;
    {
        System.out.println("Initialization Block");
        i=5;
        j=55;
    }
    BlocksExamples(){
        System.out.println("Constructor Block");
    }

    public static void main(String[] args) {
        System.out.println(i + " " + j);
        BlocksExamples obj;
        System.out.println(i + " " + j);
        obj = new BlocksExamples();
        System.out.println(i + " " + j);
    }
}
