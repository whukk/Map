package com.example.kk.map;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by KK on 2016/11/23.
 */

public class Models {
    Models(){
        Point p1 = new Point(0,91,50,"医学部","遥远的角落");
        Point p2 = new Point(1,300,50, "北门","东湖风光美，从这里走吧");
        Point p3 = new Point(2,600,50,"东北门","从这里到东北有多远？");
        Point p4 = new Point(3,817,96,"凌波门","听说附近有东湖游泳池");
        Point p5 = new Point(4,232,162   ,"变形金刚遗址","Boom回声阵阵");
        Point p6 = new Point(5,781,723,"珞珈山","贼难爬");
        Point p7 = new Point(6,458,329,"桂园宿舍","听说女生宿舍都特别棒");
        Point p8 = new Point(7,846,466,"桂园食堂","院办旁边");
        Point p9 = new Point(8,184,789,"信部宿舍","代码都是在这写完的");
        Point p10 = new Point(9,333,410,"图书馆","总是没座位");
        Point p11 = new Point(10,399,529,"珞珈广场","美如画");
        Point p12 = new Point(11,217,648,"珞珈山庄","山中别业");
        Point p13 = new Point(12,115,492,"樱花大道","秒速五厘米");
        Point p14 = new Point(13,423,720,"青楼","正经的学习好去处");
        Point p15 = new Point(14,619,389,"信图","自习好去处");
        Point p16 = new Point(15,539,1254,"计算机院办","大本营");
        Point p17 = new Point(16,200,1189,"国软","信部的难兄难弟");
        Point p18 = new Point(17,491,1078,"操场","不刷汉姆不来");
        Point p19 = new Point(18,778,899,"体育馆","打乒乓球的好地方");
        Point p20 = new Point(19,140,300,"大学生活动中心","大型活动在这里");
        Point p21 = new Point(20,154,944,"星湖园","星湖在哪？");
        Point p22 = new Point(21,467,866,"梅园","梅园电影院");
        Point p23 = new Point(22,709,1146,"桂操","锻炼身体好地方");
        Point p24 = new Point(23,635,195,"912操场","阅兵给你看");
        Point p25 = new Point(24,629,609,"教五","珞珈广场旁");

        addPoint(p1);addPoint(p2);addPoint(p3);addPoint(p4);addPoint(p5);
        addPoint(p6);addPoint(p7);addPoint(p8);addPoint(p9);addPoint(p10);
        addPoint(p11);addPoint(p12);addPoint(p13);addPoint(p14);addPoint(p15);
        addPoint(p16);addPoint(p17);addPoint(p18);addPoint(p19);addPoint(p20);
        addPoint(p21);addPoint(p22);addPoint(p23);addPoint(p24);addPoint(p25);

        route r1 = new route(0,1,10);        route r2 = new route(1,23,10);
        route r3 = new route(1,2,10);        route r4 = new route(2,3,10);
        route r5 = new route(19,4,10);        route r6 = new route(4,23,10);
        route r7 = new route(5,6,10);        route r8 = new route(6,7,10);
        route r9 = new route(7,8,10);        route r10 = new route(8,9,10);
        route r11 = new route(9,10,10);        route r12 = new route(13,11,10);
        route r13 = new route(11,12,10);        route r14 = new route(12,13,10);
        route r15 = new route(13,14,10);        route r16 = new route(14,15,10);
        route r17 = new route(15,16,10);        route r18 = new route(16,17,10);
        route r19 = new route(17,18,10);        route r20 = new route(18,21,10);
        route r21 = new route(19,9,10);
        route r22 = new route(0,4,10); route r23 = new route(1,4,10);
        route r24 = new route(0,4,10);route r25 = new route(2,23,10);
        route r26 = new route(23,3,10);route r27 = new route(23,6,10);
        route r28 = new route(23,19,10);route r29 = new route(21,24,10);
        route r30 = new route(6,10,10);route r31 = new route(1,4,10);route r32 = new route(13,10,10);
        route r33 = new route(17,21,10);route r34 = new route(24,5,10);route r35 = new route(21,17,10);
        route r36 = new route(20,16,10);route r37 = new route(20,17,10);route r38 = new route(12,19,10);
        route r39 = new route(11,14,10);route r40 = new route(18,22,10);route r41 = new route(18,5,10);
        route r42 = new route(17,15,10);route r43 = new route(17,22,10);route r44 = new route(13,21,10);
        mroutes.add(r1);mroutes.add(r2);mroutes.add(r3);mroutes.add(r4);mroutes.add(r5);
        mroutes.add(r6);mroutes.add(r7);mroutes.add(r8);mroutes.add(r9);mroutes.add(r10);
        mroutes.add(r11);mroutes.add(r12);mroutes.add(r13);mroutes.add(r14);mroutes.add(r15);
        mroutes.add(r16);mroutes.add(r17);mroutes.add(r18);mroutes.add(r19);mroutes.add(r20);
        mroutes.add(r21);mroutes.add(r22);mroutes.add(r23);mroutes.add(r24);mroutes.add(r25);
        mroutes.add(r26);mroutes.add(r27);mroutes.add(r28);mroutes.add(r29);mroutes.add(r30);
        mroutes.add(r31);mroutes.add(r32);mroutes.add(r33);mroutes.add(r34);mroutes.add(r35);
        mroutes.add(r36);mroutes.add(r37);mroutes.add(r38);mroutes.add(r39);mroutes.add(r40);
        mroutes.add(r41);mroutes.add(r42);mroutes.add(r43);mroutes.add(r44);

    }
    public static ArrayList<Point> mPoints = new ArrayList<Point>();
    public static ArrayList<route> mroutes = new ArrayList<route>();
    private static final float INF=Integer.MAX_VALUE;
    private static final int MAXV=1000;
    private static float[][] A= new float[MAXV][MAXV];
    private static int[][] path = new int[MAXV][MAXV];

    public static ArrayList<Point> getPoints() {
        return mPoints;
    }
    public static ArrayList<route> getroutes() {
        return mroutes;
    }
    public static void addPoint(Point p) {
        mPoints.add(p);
    }
    public static Point findPointByid(int id){
        
        for(Point p : mPoints ) {
            if(p.number==id)
                return p;
        }
        return null;
    }
    public static ArrayList<Point> getPath(Point from,Point to) {
        pathINI();
        int n = mPoints.size();
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(A[i][j]>A[i][k]+A[k][j]){
                        A[i][j]=A[i][k]+A[k][j];
                        path[i][j]=path[k][j];
                    }
                }
            }
        }

        int k=0;
        ArrayList<Point> apath = new ArrayList<Point>();
        apath.add(to);
        //遍历from的number那行
        k=path[from.number][to.number];
        while(k!=from.number){
            apath.add(findPointByid(k));
            k=path[from.number][k];
        }
        apath.add(from);
        return  apath;//如果为了描绘轨迹的话倒是并不需要正序

    }

    public static float getMinDis(Point from,Point to){
        pathINI();
        int n = mPoints.size();
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(A[i][j]>A[i][k]+A[k][j]){
                        A[i][j]=A[i][k]+A[k][j];
                        path[i][j]=path[k][j];
                    }
                }
            }
        }

        int k=0;
        float distance=0;
        Point oldP=to;
        Point newP=null;
        k=path[from.number][to.number];
        while(k!=from.number){
            newP=findPointByid(k);
            distance=distance+getDistance(newP,oldP);
            oldP=newP;
            k=path[from.number][k];
        }
        newP=from;
        distance=distance+getDistance(oldP,newP);
        return distance;
    }

    public static boolean pathINI() {//初始化path表和路径表
        int n=mPoints.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                path[i][j]=-1;
                if(i==j)
                    A[i][j]=0;
                else
                    A[i][j]=INF;
            }
        }
        for(route r:mroutes){
            path[r.from][r.to]=r.from;
            path[r.to][r.from]=r.to;
            A[r.from][r.to]=getDistance(findPointByid(r.from),findPointByid(r.to));
            A[r.to][r.from]=A[r.from][r.to];
        }
        //初始化结束
        return true;
    }
    public static float getDistance(Point from,Point to){
        float x2,y2;
        x2=(from.x-to.x)*(from.x-to.x);
        y2=(from.y-to.y)*(from.y-to.y);
        return (float) Math.sqrt(x2+y2);
    }
    public static Point getLimDisPoint(){
        pathINI();
        int n = mPoints.size();
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(A[i][j]>A[i][k]+A[k][j]){
                        A[i][j]=A[i][k]+A[k][j];
                        path[i][j]=path[k][j];
                    }
                }
            }
        }
        float[] totalDistance = new float[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                totalDistance[i]=totalDistance[i]+A[i][j];
            }
        }
        float maxv= Float.MAX_VALUE;
        int flag=0;
        for(int i=0;i<n;i++){
            if(totalDistance[i]<maxv){
                flag=i;
                maxv=totalDistance[i];
            }
        }
        return findPointByid(flag);
    }
}
