package com.company;

public class TestFunction {
    public int test;

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public TestFunction(int test) {
        this.test = test;
    }

    public String toString() {
        return "TestFunction object contains number " +
                + test;
    }

    public void onCreatefori(){
        for (int count = 0;count < 10 ;count++)
        {
            System.out.println("Counter "+count);
        }
    }

}
