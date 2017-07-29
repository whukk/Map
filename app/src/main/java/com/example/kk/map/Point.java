package com.example.kk.map;

/**
 * Created by kk on 2016/11/23.
 */

public class Point {
    public int number;
    public float x;
    public float y;
    public String name;
    public String description;

    Point(int number,float x,float y,String name,String description) {
        this.number=number;
        this.x=x;
        this.y=y;
        this.name=name;
        this.description=description;
    }

    Point(float x,float y){
        this.number=Models.mPoints.size();
        this.x=x;
        this.y=y;
        this.name = "自动添加的点";
        this.description="自动生成的点";
    }
}
