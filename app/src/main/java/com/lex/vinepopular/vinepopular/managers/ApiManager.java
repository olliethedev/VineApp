package com.lex.vinepopular.vinepopular.managers;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lex.vinepopular.vinepopular.MyApplication;
import com.lex.vinepopular.vinepopular.models.PopularVids;
import com.lex.vinepopular.vinepopular.requests.BaseRequest;


/**
 * Created by Oleksiy on 1/30/2016.
 */
public class ApiManager {
    public static final int CACHE_SIZE = 1024 * 1024 * 4;//4mb
    private static final String GET_POPULAR_URL = "https://community-vineapp.p.mashape.com/timelines/popular";
    private static RequestQueue requestQueue;
    private static ApiManager instance;

    private ApiManager(){}

    public static ApiManager getInstance(){
        if(instance==null){
            instance = new ApiManager();
        }
        return instance;
    }

    /**
     *
     * @param completion Class implementing this interface will receive completion information;
     */
    public void getPopularVids(final BaseRequest.RequestCompletion<PopularVids> completion) {
        BaseRequest<PopularVids> request = new BaseRequest<>(GET_POPULAR_URL, PopularVids.class, completion);
        getRequestQueue().add(request);
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(MyApplication.getContext(),CACHE_SIZE);
        }
        return requestQueue;
    }


}
