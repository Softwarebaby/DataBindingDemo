package com.qingcheng.du.app2.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qingcheng.du.app2.R;
import com.qingcheng.du.app2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    private void inject() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new Presenter();
        binding.setPresenter(presenter);
    }

    public class Presenter {
        public String message = "~";

        public void baseDataBinding() {
            startActivity(new Intent(MainActivity.this, DataBindingBaseActivity.class));
        }
    }
}
