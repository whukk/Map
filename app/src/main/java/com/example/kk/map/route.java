package com.example.kk.map;

/**
 * Created by XMKZ on 2016/11/23.
 */

public class route {
    public int from;
    public int to;
    public  float distance;

    route(int from ,int to ,float distance) {
        this.distance=distance;
        this.from=from;
        this.to=to;
    }
}
