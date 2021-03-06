package com.justdoit.elementlibrary.base.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.R2;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.justdoit.elementlibrary.widget.TitleLayout;

import butterknife.BindView;


/**
 * 带有标题栏的activity
 */
public abstract class BaseTitleActivity<P extends IPresenter> extends BaseActivity<P> {

    @BindView(R2.id.lyt_title)
    TitleLayout mLytTitle;
    @BindView(R2.id.view_gradient_divider)
    View mViewGradientDivider;
    @BindView(R2.id.lyt_content)
    ViewStub mLytContent;
    @BindView(R2.id.lyt_loading)
    FrameLayout mLytLoading;
    @BindView(R2.id.lyt_empty)
    FrameLayout mLytEmpty;

    @Override
    public int getContentView() {
        return R.layout.activity_base_title;
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        mLytContent.setLayoutResource(getContentLayoutId());
        mLytContent.inflate();
    }

    public TitleLayout getTitleLayout() {
        return mLytTitle;
    }

    public void setTitleShow(boolean show) {
        mLytTitle.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setShowDivider(boolean show) {
        mViewGradientDivider.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setLoadingView(View view) {
        mLytLoading.removeAllViews();
        mLytLoading.addView(view);
    }

    public void setEmptyView(View view) {
        mLytLoading.removeAllViews();
        mLytLoading.addView(view);
    }

    public void showEmptyView() {
        mLytEmpty.setVisibility(View.VISIBLE);
    }

    public void dismissEmptyView() {
        mLytEmpty.setVisibility(View.GONE);
    }

    public void showLoadingView() {
        mLytLoading.setVisibility(View.VISIBLE);
    }

    public void dismissLoadingView() {
        mLytLoading.setVisibility(View.GONE);
    }

    protected abstract @LayoutRes
    int getContentLayoutId();

}
