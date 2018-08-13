package com.qingcheng.du.app2.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.qingcheng.du.app2.R;
import com.qingcheng.du.app2.databinding.ActivityRecyclerBindBinding;
import com.qingcheng.du.app2.model.Student;
import com.qingcheng.du.app2.view.adapter.SimpleBindAdapter;
import com.qingcheng.du.app2.view.adapter.base.IBaseBindingPresenter;

import java.util.ArrayList;

public class RecyclerBindActivity extends AppCompatActivity {
    private ActivityRecyclerBindBinding binding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private void bind() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_bind);
        ArrayList<Student> students = getStudents();
        SimpleBindAdapter adapter = new SimpleBindAdapter(students, R.layout.item_recycler_view);
        adapter.setItemPresenter(new RecyclerBindPresenter());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(adapter);
    }

    public class RecyclerBindPresenter implements IBaseBindingPresenter {
        public void onNameClick(Student student) {
            Toast.makeText(RecyclerBindActivity.this, student.getName()+" 修改姓名", Toast.LENGTH_SHORT).show();
            student.setName("New Name");
        }
        public void onAgeClick(Student student) {
            Toast.makeText(RecyclerBindActivity.this, "修改年龄", Toast.LENGTH_SHORT).show();
            student.setAge(student.getAge()+5);
        }
    }
    private ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("jack",12));
        students.add(new Student("rose", 13));
        students.add(new Student("tom", 22));
        students.add(new Student("jerry", 20));
        return students;
    }
}
