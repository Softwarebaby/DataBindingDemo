package com.qingcheng.du.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qingcheng.du.databindingdemo.bean.User;
import com.qingcheng.du.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //绑定数据
        User user = new User("du", "du123");
        dataBinding.setUser(user);

        //....
    }
}
