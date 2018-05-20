package com.example.umanga.clicker;

/**
 * Created by Umanga on 7/9/2017.
 */

public class StoreValues {

    public static StoreValues mInstance = new StoreValues();

    public  StoreValues(){}

    public static StoreValues getInstance() {
      return mInstance;
    }

    public  int no1 = 0;
    public  int no2 = 0;
    public  int no3=0;


    public void setNo1(int no1) {
        this.no1 = no1;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }
    public void setNo3(int no3) {this.no3 = no3;}
    public int getNo3() {return no3;}

    public int getNo1() {
        return no1;
    }

    public int getNo2() {
        return no2;
    }


}
