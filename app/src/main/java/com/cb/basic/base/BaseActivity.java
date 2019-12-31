package com.cb.basic.base;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.cb.basic.bean.DialogBean;
import com.cb.basic.lifecycle.BaseViewModel;

/**
 * create date on 2019/12/31
 *
 * @author Cbin
 * describe ViewModel、ViewDataBinding都需要的基类
 */
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding>
        extends BaseNoModelActivity<VDB> {


    protected VM viewModel;

    @Override
    protected VDB initDataBinding(int layoutId) {
        VDB db = super.initDataBinding(layoutId);
        /**
         * 将这两个初始化函数插在{@link BaseActivity#initDataBinding}
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