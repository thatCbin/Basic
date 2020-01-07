package com.cb.basic.myapp;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.cb.basic.R;
import com.cb.basic.base.ui.BaseActivity;
import com.cb.basic.base.ui.BaseNoModelActivity;
import com.cb.basic.databinding.ActivityMainBinding;
import com.cb.basic.lifecycle.BaseViewModel;
import com.cb.basic.myapp.bean.response.NameResponse;
import com.cb.basic.uitils.UIUtils;

/**
 * @author Cbin
 */
public class MainActivity extends BaseActivity<NameViewModel,ActivityMainBinding> {
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected NameViewModel initViewModel() {
        return ViewModelProviders.of(this).get(NameViewModel.class);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
        viewModel.getNews().observe(this, new Observer<NameResponse>() {
            @Override
            public void onChanged(NameResponse response) {
                if (response.is_ok==0){
                    System.out.println("**9 请求成功");
                }
            }
        });
    }

    public void item(View view, int position) {
        switch (position) {
            case 0:
                viewModel.Test();
                UIUtils.showToast(position + "0");
                break;
            case 1:
                UIUtils.showToast(position + "1");
                break;
            case 2:
                UIUtils.showToast(position + "2");
                break;
            case 3:
                UIUtils.showToast(position + "3");
                break;
            default:
                break;
        }
    }

    @Override
    protected void showError(Object obj) {

    }
}
