package com.cb.basic.lifecycle;

import androidx.lifecycle.MutableLiveData;

import com.cb.basic.bean.DialogBean;

/**
 * create date on 2019/12/31
 *
 * @author Cbin
 * describe
 */
public final class DialogLiveData<T> extends MutableLiveData<T> {
    private DialogBean bean = new DialogBean();

    public void setValue(boolean isShow) {
        bean.setShow(isShow);
        bean.setMsg("");
        setValue((T) bean);
    }

    public void setValue(boolean isShow, String msg) {
        bean.setShow(isShow);
        bean.setMsg(msg);
        setValue((T) bean);
    }

}
