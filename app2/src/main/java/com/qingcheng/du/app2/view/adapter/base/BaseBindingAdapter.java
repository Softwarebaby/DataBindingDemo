package com.qingcheng.du.app2.view.adapter.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qingcheng.du.app2.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob Du on 2018/8/13 10:19
 */
public abstract class BaseBindingAdapter<T, D extends ViewDataBinding> extends RecyclerView.Adapter<BaseViewHolder<D>>{
    private List<T> mDatas;
    private int layoutId;

    //用于设置Item事件的Presenter
    protected IBaseBindingPresenter ItemPresenter;

    public BaseBindingAdapter(List<T> mDatas, int layoutId) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;
    }

    public abstract void onCreateViewHolder(BaseViewHolder<D> holder);

    @NonNull
    @Override
    public BaseViewHolder<D> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BaseViewHolder<D> viewHolder = new BaseViewHolder<D>((D) DataBindingUtil.inflate(inflater, layoutId, parent, false));
        onCreateViewHolder(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<D> holder, int position) {
        Log.i("tag", "onBindViewHolder");
        holder.getBinding().setVariable(BR.data, mDatas.get(position));
        holder.getBinding().setVariable(BR.itmePresenter, ItemPresenter);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    /**
     * 用于设置Itme的事件Presenter
      * @param itemPresenter
     * @return
     */
    public BaseBindingAdapter setItemPresenter(IBaseBindingPresenter itemPresenter) {
        ItemPresenter = itemPresenter;
        return this;
    }
    /**
     * 刷新数据，初始化数据
     * @param list
     */
    public void setDatas(List<T> list) {
        if(this.mDatas != null) {
            if(list != null) {
                List<T> temp = new ArrayList<>();
                temp.addAll(list);
                this.mDatas.clear();
                this.mDatas.addAll(temp);
            } else {
                this.mDatas.clear();
            }
            notifyDataSetChanged();
        }
    }

    /**
     * 删除一条数据
     * 会自动定向刷新
     * @param i
     */
    public void remove(int i ) {
        if(mDatas != null && mDatas.size() >i && i > -1) {
            mDatas.remove(i);
            notifyItemRemoved(i);
        }
    }

    /**
     * 添加一条数据至队尾
     * 会自动定向刷新
     * @param data
     */
    public void add(T data) {
        if(data != null && mDatas != null) {
            mDatas.add(data);
            notifyItemInserted(mDatas.size());
        }
    }
    /**
     * 在指定位置添加一条数据
     * 会自动定向刷新
     * （如果指定位置越界，则添加到队尾）
     * @param positon
     * @param data
     */
    public void add(int positon, T data) {
        if(data != null && mDatas != null) {
            if(mDatas.size() > positon && positon > -1) {
                mDatas.add(positon, data);
                notifyItemInserted(positon);
            }else{
//                add(data);
            }
        }
    }

    /**
     * 加载更多数据
     * @param list
     */
    public void addDatas(List<T> list) {
        if(list != null) {
            List<T> temp = new ArrayList<>();
            temp.addAll(list);
            if(this.mDatas != null) {
                this.mDatas.addAll(temp);
            }else{
                this.mDatas = temp;
            }
            notifyDataSetChanged();
        }
    }
}
