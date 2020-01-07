package com.cb.basic.myapp;

import androidx.lifecycle.MutableLiveData;

import com.cb.basic.lifecycle.BaseViewModel;
import com.cb.basic.myapp.api.ApiRetrofit;
import com.cb.basic.myapp.api.ApiService;
import com.cb.basic.myapp.bean.entity.NameEntity;
import com.cb.basic.myapp.bean.response.NameResponse;
import com.socks.library.KLog;

import rx.android.schedulers.AndroidSchedulers;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class NameViewModel extends BaseViewModel {
    //protected ApiService mApiService = ApiRetrofit.getInstance().getApiService();
    private ApiService mApiService = ApiRetrofit.getInstance().getApiService();
    private CompositeSubscription mCompositeSubscription;

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        boolean unsubscribed = subscriber.isUnsubscribed();
        KLog.e(unsubscribed);
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
        boolean unsubscribed2 = subscriber.isUnsubscribed();
        KLog.e(unsubscribed2);
    }

    /**
     *  当前数据请求成功时回调
     */
    protected MutableLiveData<NameResponse> responst=new MutableLiveData<>();

    /**
     *  请求网络
     */
    public void Test(){
        String action="Test";
        addSubscription(mApiService.Test(action), new Subscriber<NameResponse> (){
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                KLog.e(e.getLocalizedMessage());
                System.out.println("**9 请求失败");
            }

            @Override
            public void onNext(NameResponse response) {
                responst.setValue(response);
            }
        });

    }

    public MutableLiveData<NameResponse> getNews() {
        return responst;
    }
}
