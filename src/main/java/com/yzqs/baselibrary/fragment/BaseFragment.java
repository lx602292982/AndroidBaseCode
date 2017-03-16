package com.yzqs.baselibrary.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;
import com.yzqs.baselibrary.activity.BaseActivity;

import butterknife.ButterKnife;


/**
 * Author: Othershe
 * Time:  2016/8/11 10:41
 */
public abstract class BaseFragment extends RxFragment {
    protected BaseActivity mActivity;
    protected View mRootView;

    protected abstract int initLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initLayoutId();
        mRootView = inflater.inflate(initLayoutId(), container, false);
        ButterKnife.inject(this, mRootView);
        initView();
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
