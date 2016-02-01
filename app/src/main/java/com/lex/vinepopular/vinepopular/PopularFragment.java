package com.lex.vinepopular.vinepopular;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.lex.vinepopular.vinepopular.adapters.BindingAdapter;
import com.lex.vinepopular.vinepopular.databinding.FragmentPopularBinding;
import com.lex.vinepopular.vinepopular.managers.ApiManager;
import com.lex.vinepopular.vinepopular.models.PopularVids;
import com.lex.vinepopular.vinepopular.models.PopularVidsViewModel;
import com.lex.vinepopular.vinepopular.requests.BaseRequest;


public class PopularFragment extends BaseFragment {

    private FragmentPopularBinding binding;
    private PopularVidsViewModel viewModel;
    private RecyclerView gridRecyclerView;
    private BindingAdapter adapter;


    public static PopularFragment newInstance() {
        PopularFragment fragment = new PopularFragment();
        //set args
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get args
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false);
        viewModel = new PopularVidsViewModel();
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    protected void setupView(View view) {
        loadData();
    }

    private void loadData() {
        ApiManager.getInstance().getPopularVids(new BaseRequest.RequestCompletion<PopularVids>() {
            @Override
            public void onResponse(PopularVids data) {
                Log.i("PopularFragment", data.toString());
                viewModel.popularVids.set(data);
                setupViewComplete();
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_LONG).show();
                setupViewComplete();
            }
        });
    }
}
