package com.qingcheng.du.app2.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.qingcheng.du.app2.R;
import com.qingcheng.du.app2.databinding.ActivityDataBindingBaseBinding;
import com.qingcheng.du.app2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DataBindingBaseActivity extends AppCompatActivity {
    private ActivityDataBindingBaseBinding binding;
    private Student student;
//    private List<String> contents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    private void inject() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_base);

        student = new Student("Bob", 21);
//        contents.add("content => 0");
//        contents.add("content => 1");

        //给XML中的student进行赋值（两种方式）
        binding.setStudent(student);
//        binding.setVariable(BR.student, student);
        binding.setPresenter(new Presenter());
//        binding.setContents(contents);
    }

    public class Presenter {
        public void onNameClick(String name) {
            Toast.makeText(DataBindingBaseActivity.this, name, Toast.LENGTH_SHORT).show();
        }
        public void onAgeClick(int age) {
            Toast.makeText(DataBindingBaseActivity.this, String.valueOf(age), Toast.LENGTH_SHORT).show();
        }
    }
}
