package com.lex.vinepopular.vinepopular;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.lex.vinepopular.vinepopular.adapters.BindingAdapter;
import com.lex.vinepopular.vinepopular.databinding.FragmentPopularBinding;
import com.lex.vinepopular.vinepopular.models.PopularVids;
import com.lex.vinepopular.vinepopular.models.TestModel;


public class PopularFragment extends Fragment {

    private TestModel testModel;
    private FragmentPopularBinding binding;
    private RecyclerView gridRecyclerView;
    private BindingAdapter<PopularVids.Record> adapter;
    public PopularFragment() {
        // Required empty public constructor
    }

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
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridRecyclerView = (RecyclerView) view.findViewById(R.id.popular_grid_recycler_view);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new BindingAdapter<>(R.layout.popular_vid_item, com.lex.vinepopular.vinepopular.BR.record);
        gridRecyclerView.setAdapter(adapter);
        ApiManager.getInstance().getPopularVids(new GsonRequest.RequestCompletion<PopularVids>() {
            @Override
            public void onResponse(PopularVids data) {
                Toast.makeText(getContext(),"success",Toast.LENGTH_LONG).show();
                Log.i("PopularFragment",data.toString());
                adapter.setData(data.data.records);
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(getContext(),"failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}
