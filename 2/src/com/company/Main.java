package com.company;

public class Main {

    public static void main(String[] args) {
	//TODO make a new Class
        System.out.println("Hello World!");

        TestFunction OBJ = new TestFunction(1);

        for(int i=0;i<9;i++)
        {
            if(i>-1)
            {
                if(i<10)
                {
                    System.out.println(i);
                }
            }
        }

        System.out.println(OBJ.toString());

        OBJ.onCreatefori();
    }

}
