package com.cb.basic.myapp;

import android.view.View;

import com.cb.basic.R;
import com.cb.basic.base.ui.BaseNoModelActivity;
import com.cb.basic.databinding.ActivityMainBinding;
import com.cb.basic.uitils.UIUtils;

public class MainActivity extends BaseNoModelActivity<ActivityMainBinding> {
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
    }

    public void item(View view, int position) {
        switch (position) {
            case 0:
                UIUtils.showToast(position + "");
                break;
            case 1:
                UIUtils.showToast(position + "");
                break;
            case 2:
                UIUtils.showToast(position + "");
                break;
            case 3:
                UIUtils.showToast(position + "");
                break;
            default:
                break;
        }
    }
}
