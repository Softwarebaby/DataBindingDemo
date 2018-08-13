package com.qingcheng.du.app2.view.adapter;

import com.qingcheng.du.app2.databinding.ItemRecyclerViewBinding;
import com.qingcheng.du.app2.model.Student;
import com.qingcheng.du.app2.view.adapter.base.BaseBindingAdapter;
import com.qingcheng.du.app2.view.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Bob Du on 2018/8/13 11:40
 */
public class SimpleBindAdapter extends BaseBindingAdapter<Student, ItemRecyclerViewBinding> {
    public SimpleBindAdapter(List<Student> mDatas, int layoutId) {
        super(mDatas, layoutId);
    }

    @Override
    public void onCreateViewHolder(BaseViewHolder<ItemRecyclerViewBinding> holder) {

    }
}
