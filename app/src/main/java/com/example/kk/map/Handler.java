package com.example.kk.map;

/**
 * Created by XMKZ on 2016/11/23.
 */

public class Handler {
    public static int condition = 0;
    public static int ShowRoute = 1;


    public static final int show = 1;
    public static final int hide = 0;
    public static final int INFO_CHECK = 0;
    public static final int SELECTING_0 =1;
    public static final int SELECTING_1 =2;
    public static final int SELECTED =3;
    public static final int SETMARKET=4;
    public static final int CHANGELOCATION=5;
    public static final int CREATPOINTS=6;
    public static final int DELETE=7;
    public static void setCondition(int condition) {
        Handler.condition = condition;
    }
}
