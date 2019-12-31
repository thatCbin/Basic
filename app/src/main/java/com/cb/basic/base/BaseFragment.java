package com.cb.basic.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.cb.basic.bean.DialogBean;
import com.cb.basic.lifecycle.BaseViewModel;

/**
 * create date on 2019/12/31
 *
 * @author Cbin
 * describe
 */

public abstract class BaseFragment<VM extends BaseViewModel, VDB extends ViewDataBinding>
        extends BaseNoModelFragment<VDB> {

    protected VM viewModel;

    @Override
    protected VDB initDataBinding(LayoutInflater inflater, int layoutId, ViewGroup container) {
        VDB db = super.initDataBinding(inflater, layoutId, container);
        /**
         * 将这两个初始化函数插在{@link BaseFragment#initDataBinding}
         */
        viewModel = initViewModel();
        initObserve();
        return db;
    }

    /**
     * 初始化ViewModel
     */
    protected abstract VM initViewModel();

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private void initObserve() {
        if (viewModel == null) {
            return;
        }
        viewModel.getShowDialog(this, new Observer<DialogBean>() {
            @Override
            public void onChanged(DialogBean bean) {
                if (bean.isShow()) {
                    showDialog(bean.getMsg());
                } else {
                    dismissDialog();
                }
            }
        });
        viewModel.getError(this, new Observer<Object>() {
            @Override
            public void onChanged(Object obj) {
                showError(obj);
            }
        });
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract void showError(Object obj);
}