package com.cb.basic.base.adapter;

/**
 * create date on 2019/12/31
 *
 * @author Cbin
 * describe RecyclerView Item 长按、点击事件
 */
public interface OnItemClickListener<Data> {

    /**
     * Item 点击事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    void onItemClick(Data data, int position);

    /**
     * Item 长按事件
     *
     * @param data     item的数据
     * @param position item的下标
     */
    boolean onItemLongClick(Data data, int position);
}
