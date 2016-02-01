package com.lex.vinepopular.vinepopular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public abstract class BaseFragment extends Fragment {
    private OnRefreshDoneListener refreshListener;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setupView(view);
    }

    protected abstract void setupView(View view);

    protected void setupViewComplete() {//must be called after view is done setting up, i.e. at the end of network call
        if (refreshListener != null) {
            refreshListener.onRefreshDone();
        }
    }

    public void refresh(OnRefreshDoneListener listener) {
        this.refreshListener = listener;
        if (getView() != null) {
            setupView(getView());
        }
    }

    public MainActivity getBaseActivity() {
        return (MainActivity) super.getActivity();
    }

    public void setRefreshListener(OnRefreshDoneListener refreshListener) {
        this.refreshListener = refreshListener;
    }

    public interface OnRefreshDoneListener {
        void onRefreshDone();
    }
}
