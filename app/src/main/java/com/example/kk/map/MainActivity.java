package com.example.kk.map;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Models mModels = new Models();
    public Handler mHandler = new Handler();
    private Button nearest ;
    private Button setMarket;
    private Button changeLocation;
    private Button creatPoints;
    private CheckBox mCheckBox;
    private Button delete_button;
    public int screenHeight,screenWidth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;

        nearest = (Button) findViewById(R.id.nearest);
        setMarket=(Button) findViewById(R.id.setMarket);
        setMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler.setCondition(Handler.SETMARKET);
                Toast.makeText(MainActivity.this,"请点击屏幕确认",Toast.LENGTH_SHORT).show();
            }
        });
        delete_button=(Button) findViewById(R.id.delete_button);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler.setCondition(Handler.DELETE);
                Toast.makeText(MainActivity.this,"点击任意一点删除",Toast.LENGTH_SHORT).show();
            }
        });
        mCheckBox=(CheckBox)findViewById(R.id.checkBox_showRoute);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){//如果选中
                    Handler.ShowRoute=Handler.show;
                }
                else{
                    Handler.ShowRoute=Handler.hide;
                }
            }
        });
        changeLocation = (Button) findViewById(R.id.changeLocation);
        changeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Handler.condition!=Handler.CHANGELOCATION){
                    Handler.setCondition(Handler.CHANGELOCATION);
                    creatPoints.setText("添加新点");
                    Toast.makeText(MainActivity.this,"请拖动任意点改变位置",Toast.LENGTH_SHORT).show();
                    changeLocation.setText("结束移动");
                }
                else{
                    Handler.setCondition(Handler.INFO_CHECK);
                    changeLocation.setText("更改位置");
                }
            }
        });
        creatPoints=(Button) findViewById(R.id.creatPoints);
        creatPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Handler.condition!=Handler.CREATPOINTS){
                    Handler.setCondition(Handler.CREATPOINTS);
                    changeLocation.setText("更改位置");
                    Toast.makeText(MainActivity.this, "点击任意位置创建新点", Toast.LENGTH_SHORT).show();
                    creatPoints.setText("创建完毕");
                }
                else{
                    creatPoints.setText("添加新点");
                    Handler.condition=Handler.INFO_CHECK;
                }
                }
            });

        nearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"请选择两个点",Toast.LENGTH_SHORT).show();
                Handler.setCondition(Handler.SELECTING_0);
            }
        });
    }


}
