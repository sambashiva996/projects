package com.core.java.core_java_programs.practice;

public class StarredPrograms {
    public static void main(String[] args) {
        /**
         *****
         *****
         *****
         *****
         *****

         * */
        int n = 5;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
///////////////////////////////////////////////////

        /**
         *
         **
         ***
         ****
         *****
         * */
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        ///////////////////////////////////

        /**
         *****
         ****
         ***
         **
         *
         * */
        for (int i = n; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        /////////////////////////////////
        /*
         *
        **
       ***
      ****
     *****
          */
        for (int i = 1; i <= n; i++){
            for (int j = n-1; j >= i; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        //////////////////////////////////////

        /*
        *****
         ****
          ***
           **
            *
           */
        for (int i = n; i >= 1; i--){
            for (int j = n-1; j >= i; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        ///////////////////////////////////////////

        /*
             *
            * *
           * * *
          * * * *
         * * * * *

         */
        for (int i = 1; i <= n; i++){
            for (int j = n-1; j >= i; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <=i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
        ///////////////////////////////////////
        /*

             *
            ***
           *****
          *******
         *********

        */
        int star = 1;
        for (int i = 1; i <= n; i++){
            for (int j = n-1; j >= i; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <= star; k++){
                System.out.print("*");
            }
            star += 2;
            System.out.println();
        }
    }
}
