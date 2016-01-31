package com.lex.vinepopular.vinepopular;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.lex.vinepopular.vinepopular.databinding.FragmentPopularBinding;
import com.lex.vinepopular.vinepopular.models.PopularVids;
import com.lex.vinepopular.vinepopular.models.TestModel;


public class PopularFragment extends Fragment {

    private TestModel testModel;

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
        FragmentPopularBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false);
        testModel = new TestModel();
        testModel.setName("initial");
        testModel.setImageUrl("http://developer.android.com/assets/images/android_logo.png");
        binding.setTestObject(testModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        testModel.setName("download started...");
        ApiManager.getInstance().getPopularVids(new GsonRequest.RequestCompletion<PopularVids>() {
            @Override
            public void onResponse(PopularVids data) {
                Toast.makeText(getContext(),"success",Toast.LENGTH_LONG).show();
                Log.i("PopularFragment",data.toString());
                testModel.setName("download finished");
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(getContext(),"failed",Toast.LENGTH_LONG).show();
                testModel.setName("download failed");
            }
        });
    }
}
