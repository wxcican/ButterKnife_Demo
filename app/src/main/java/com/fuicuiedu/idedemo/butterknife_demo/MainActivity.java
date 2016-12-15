package com.fuicuiedu.idedemo.butterknife_demo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindViews({R.id.main_tv1,R.id.main_tv2,R.id.main_tv3})
    List<TextView> textViewList;

    private Unbinder unBinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //必须调用的方法！
        unBinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.main_btn1,R.id.main_btn2,R.id.main_btn3})
    public void aaa(View v){
        switch (v.getId()){
            case R.id.main_btn1:
                Toast.makeText(this, "点击了Button1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn2:
                Toast.makeText(this, "点击了Button2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn3:
                Toast.makeText(this, "点击了Button3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在生命周期结束时解绑
        unBinder.unbind();
    }
}
