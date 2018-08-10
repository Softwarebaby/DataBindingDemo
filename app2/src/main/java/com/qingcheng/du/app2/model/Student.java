package com.qingcheng.du.app2.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.qingcheng.du.app2.BR;

/**
 * Created by Bob Du on 2018/8/10 14:37
 */
/*
    基本的数据绑定
 */
public class Student extends BaseObservable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * ObservableObject实现数据绑定
     */
    @Bindable
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    /**
     * ObservableFields实现数据绑定（推荐）
     */
    public final ObservableField<String> nameOF = new ObservableField<>();
    public final ObservableField<String> ageOF = new ObservableField<>();
}
