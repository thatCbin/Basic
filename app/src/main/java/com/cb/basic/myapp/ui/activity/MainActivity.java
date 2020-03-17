package com.cb.basic.myapp.ui.activity;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.cb.basic.R;
import com.cb.basic.base.ui.BaseActivity;
import com.cb.basic.databinding.ActivityMainBinding;
import com.cb.basic.myapp.bean.entity.NameEntity;
import com.cb.basic.myapp.bean.response.NameResponse;
import com.cb.basic.myapp.ui.viewmodel.MainViewModel;
import com.cb.basic.uitils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cbin
 */
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    protected void initView() {
    }

    private List<NameEntity> mDataList = new ArrayList();

    @Override
    protected void initData() {
        dataBinding.setModel(this);
        viewModel.getNews().observe(this, new Observer<NameResponse>() {
            @Override
            public void onChanged(NameResponse response) {
                if (response.is_ok == 0) {
                    System.out.println("**9 请求成功");
                    NameEntity entity = new NameEntity();
                    entity.setName(response.result.getName());
                    entity.setAge(response.result.getAge());
                    mDataList.add(entity);
                    System.out.println("**9+" + mDataList);
                    UIUtils.showToast(entity.getName());
                    UIUtils.showToast(entity.getAge());
                    dataBinding.setName(response);
                    //dataBinding.notifyChange();
                }
            }
        });
    }

    public void item(View view, int position) {
        switch (position) {
            case 0:
                viewModel.Test();
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
