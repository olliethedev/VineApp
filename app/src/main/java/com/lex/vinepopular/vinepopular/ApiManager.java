package com.lex.vinepopular.vinepopular;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lex.vinepopular.vinepopular.models.PopularVids;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Oleksiy on 1/30/2016.
 */
public class ApiManager {
    private static final String API_KEY = "2RJ82cJEErmsh2jov7tcgoLtGsmfp1Kny0kjsnQzKixU4RuL3u";
    private static final String GET_POPULAR_URL = "https://community-vineapp.p.mashape.com/timelines/popular";
    private static RequestQueue requestQueue;
    public static final int CACHE_SIZE =1024*1024*4;//4mb
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
    public void getPopularVids(final GsonRequest.RequestCompletion<PopularVids> completion){
        GsonRequest<PopularVids> request = new GsonRequest<>(GET_POPULAR_URL,PopularVids.class,getBaseHeaders(),completion);
        getRequestQueue().add(request);
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(MyApplication.getContext(),CACHE_SIZE);
        }
        return requestQueue;
    }
    private Map<String,String> getBaseHeaders(){
        Map<String,String> headers = new HashMap<>();
        headers.put("X-Mashape-Key",API_KEY);
        headers.put("Accept","application/json");
        return headers;
    }

}
