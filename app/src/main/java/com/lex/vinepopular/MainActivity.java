package com.lex.vinepopular;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.lex.vinepopular.vinepopular.R;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnRefreshDoneListener {
    private static int FRAG_TAG = 0;
    private FrameLayout fragmentContainer;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
        setData();
    }

    private void findViews() {
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
    }

    private void setListeners() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCurrentFragment().refresh(MainActivity.this);
            }
        });
    }

    private BaseFragment getCurrentFragment() {
        return (BaseFragment) getSupportFragmentManager().findFragmentByTag(Integer.toString(FRAG_TAG - 1));
    }

    private void setData() {
        showLoading();
        BaseFragment baseFragment = PopularFragment.newInstance();
        baseFragment.setRefreshListener(this);
        showFragment(baseFragment);
    }

    public void showLoading(){
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    public void hideLoading(){
        swipeRefreshLayout.setRefreshing(false);
    }

    public void showFragment(BaseFragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, fragment, "" + FRAG_TAG);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
        FRAG_TAG++;
    }

    @Override
    public void onRefreshDone() { //current fragment refreshed data
        hideLoading();
    }
}
