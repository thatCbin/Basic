package com.cb.basic.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * create date on 2019/12/31
 *
 * @author Cbin
 * describe 结合dataBinding的RecyclerView Adapter
 */
public class BaseVDBRVAdapter<Data, VDB extends ViewDataBinding> extends RecyclerView.Adapter<BaseVDBRVHolder> {

    private List<Data> data;
    private int itemId;
    protected Context context;
    protected int variableId;
    protected OnItemClickListener<Data> listener;

    @NonNull
    @Override
    public BaseVDBRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        VDB binding = DataBindingUtil.inflate(inflater, itemId, parent, false);
        return new BaseVDBRVHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseVDBRVHolder holder, final int position) {
        VDB binding = DataBindingUtil.getBinding(holder.itemView);
        final Data itemData = data.get(position);
        binding.setVariable(variableId, itemData);
        onBindViewHolder(itemData, binding, position);
        //迫使数据立即绑定
        binding.executePendingBindings();
        //设置点击事件
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemData, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return listener.onItemLongClick(itemData, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 绑定数据
     */
    protected void onBindViewHolder(Data data, VDB binding, int position) {
    }

    /**
     * 设置新数据
     *
     * @param data
     */
    public void setNewData(List<Data> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(Data data) {
        this.data.add(data);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(List<Data> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 设置Item 长按、点击事件
     */
    public void setOnItemListener(OnItemClickListener<Data> listener) {
        this.listener = listener;
    }
}
