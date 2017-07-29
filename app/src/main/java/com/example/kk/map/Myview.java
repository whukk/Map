package com.example.kk.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by KK on 2016/11/23.
 */

public class Myview extends View {
    private float radius;
    private Point from;
    private Point to;
    private Point market;
    private Point draging;
    private ArrayList<Point> apath;
    Context mContext;
    private int x,y;
    //用于作为缓冲区的bitmap
    Bitmap cacheBitmap = null;
    Canvas cacheCavas = null;

    public Myview(Context context, AttributeSet set){
        super(context,set);



        mContext=context;
    }

//    private ArrayList<Point> mPoints=Models.mPoints;
//    private ArrayList<route> mroutes =Models.mroutes;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                Log.d("location", "x="+x+"y="+y);
                switch (Handler.condition) {
                    case Handler.INFO_CHECK : {
                        for (Point p : Models.mPoints) {
                            if ((x >= p.x - 2 * radius) && (x <= p.x + 2 * radius) && (y >= p.y - 2 * radius) && (y <= p.y + 2 * radius)) {
                                Toast.makeText(mContext, p.number + "\n" + p.name + "\n" + p.description, Toast.LENGTH_SHORT).show();
                                Log.d("is", p.name);
                                draging=p;
                                break;
                            }
                        }
                        break;
                    }
                    case Handler.SELECTING_0:{
                        for (Point p : Models.mPoints) {
                            if ((x >= p.x - 2 * radius) && (x <= p.x + 2 * radius) && (y >= p.y - 2 * radius) && (y <= p.y + 2 * radius)) {
                                Toast.makeText(mContext,"选中"+p.name+"\n"+"请选择下一个点", Toast.LENGTH_SHORT).show();
                                Handler.condition=Handler.SELECTING_1;
                                from=p;
                                break;
                            }
                        }
                        break;
                    }
                    case Handler.SELECTING_1:{
                        for (Point p : Models.mPoints) {
                            if ((x >= p.x - 2 * radius) && (x <= p.x + 2 * radius) && (y >= p.y - 2 * radius) && (y <= p.y + 2 * radius)) {
                                if(p!=from){
                                Toast.makeText(mContext,"第二个点选中"+p.name, Toast.LENGTH_SHORT).show();
                                Handler.condition=Handler.SELECTED;

                                to=p;
                                break;
                                }
                                else{
                                    Toast.makeText(mContext,"请选择与起点不同的点", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        invalidate();
                        break;
                    }
                    case Handler.SETMARKET:{
                        market=Models.getLimDisPoint();

                        invalidate();
                        break;
                    }
                    case Handler.CREATPOINTS:{
                        Point newPoint = new Point(event.getX(),event.getY());
                        Models.mPoints.add(newPoint);
                        int newPointKey = Models.mPoints.size()-1;
                        int t=Models.mPoints.size()-1;
                        int haveroute = 0;
                        while(haveroute==0){
                            for(int i=0;i<t;i++){
                                if(Math.random()<0.1&&i!=newPointKey&&Models.findPointByid(i)!=null){
                                    route newRoute = new route(i,newPointKey,10);
                                    Models.mroutes.add(newRoute);
                                    haveroute=1;
                                }
                            }
                        }
                        invalidate();
                        break;
                    }
                    case Handler.DELETE:{
                        int index=0;
                        for(Point p:Models.mPoints){
                            if ((x >= p.x - 2 * radius) && (x <= p.x + 2 * radius) && (y >= p.y - 2 * radius) && (y <= p.y + 2 * radius)) {
                                Models.mPoints.remove(index);
                                break;
                            }
                            else{
                                index++;
                            }
                        }

                        invalidate();
                        break;
                    }
                }
            }
            case MotionEvent.ACTION_MOVE:{
                if(Handler.condition==Handler.CHANGELOCATION){

                    if(draging==null){//如果拖动时没有点被选中
                        for (Point p : Models.mPoints) {
                            if ((x >= p.x - 2*radius) && (x <= p.x + 2*radius) && (y >= p.y -  2*radius) && (y <= p.y +  2*radius)) {
                                draging=p;
                                break;
                            }
                        }
                    }
                    if(draging!=null){
                        for(int i=Models.mPoints.size()-1;i>0;i--){
                            Point p = Models.mPoints.get(i);
                            if(p.equals(draging)){
                                Models.mPoints.remove(Models.mPoints.indexOf(p));
                            }
                            break;
                        }
                        draging.x=event.getX();
                        draging.y=event.getY();
                        Models.mPoints.add(draging);
                        invalidate();
                    }

                }

            break;
            }
            case MotionEvent.ACTION_UP:{
                draging=null;
                break;
            }
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        Paint paint =new Paint();
        Paint textpainter = new Paint();
        textpainter.setTextSize(40);
        //画笔设置
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(4);
        int viewWidth = this.getWidth();
        radius = viewWidth/50;
        //画点
        for(Point p : Models.mPoints) {
            canvas.drawCircle(p.x,p.y,radius,paint);
            canvas.drawText(p.name+" "+p.number,p.x+20,p.y,textpainter);
        }

        //draw routes
        Paint routesPainter = new Paint();
        routesPainter.setStrokeWidth(3);
        routesPainter.setStyle(Paint.Style.STROKE);
        routesPainter.setColor(Color.BLACK);

        if(Handler.ShowRoute==Handler.show){
            for(route r : Models.mroutes) {
                Path p = new Path();
                Point from,to;
                from = Models.findPointByid(r.from);
//            Log.d("from", from.number+"");
                to = Models.findPointByid(r.to);
//            Log.d("to",to.number+"");;
                if(from!=null&&to!=null){
                    p.moveTo(from.x,from.y);
                    p.lineTo(to.x,to.y);
                    canvas.drawPath(p,routesPainter);
                }
            }
        }

        if(Handler.condition==Handler.SELECTED){
            Path path =new Path();
            apath=Models.getPath(from,to);
            if(from.number==8&&to.number==6||from.number==6&&to.number==8){
                float dis=Models.getDistance(from,to);
                Log.d("distance",dis+"");
                if(dis>180){
                    Toast.makeText(mContext,"这两个点离得好远哦~", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(mContext,"是呀，在一起多好呀~", Toast.LENGTH_SHORT).show();
                }
            }
            for(int i=0;i<apath.size();i++){
                if(i==0){
                    path.moveTo(apath.get(i).x,apath.get(i).y);
                }
                else{
                    path.lineTo(apath.get(i).x,apath.get(i).y);
                }
            }
            Paint aWayPainter = new Paint();
            aWayPainter.setStyle(Paint.Style.STROKE);
            aWayPainter.setColor(Color.RED);
            aWayPainter.setStrokeWidth(6);
            canvas.drawPath(path,aWayPainter);
            Handler.condition=Handler.INFO_CHECK;
        }
        if(Handler.condition==Handler.SETMARKET){
            Paint marketMarker = new Paint();
            marketMarker.setColor(Color.RED);
            marketMarker.setStyle(Paint.Style.FILL);
            marketMarker.setStrokeWidth(4);
            canvas.drawCircle(market.x,market.y,radius,marketMarker);
            canvas.drawText("超市在这里",market.x+20,market.y-30,textpainter);
            Handler.condition=Handler.INFO_CHECK;
        }




    }
}
