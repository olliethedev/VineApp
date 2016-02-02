package com.lex.vinepopular.requests;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksiy on 1/30/2016.
 */
public class BaseRequest<T> extends Request<T> {
    private final static String TAG = "GsonRequest";
    private static final String API_KEY = "2RJ82cJEErmsh2jov7tcgoLtGsmfp1Kny0kjsnQzKixU4RuL3u";
    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final RequestCompletion<T> listener;

    public BaseRequest(String url, Class<T> clazz, final RequestCompletion<T> completionListener) {
        super(Method.GET, url, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                completionListener.onError(error);
            }
        });
        this.clazz = clazz;
        this.headers = getBaseHeaders();
        this.listener = completionListener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            Log.i(TAG,json);
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    private Map<String, String> getBaseHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Mashape-Key", API_KEY);
        headers.put("Accept", "application/json");
        return headers;
    }
    public interface RequestCompletion<T>{
        void onResponse(T data);
        void onError(VolleyError error);
    }
}
