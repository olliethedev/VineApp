package com.lex.vinepopular.vinepopular;

import android.app.Application;
import android.content.Context;

/**
 * Created by Oleksiy on 1/30/2016.
 */
public class MyApplication extends Application {
    private static Context context;

    public MyApplication() {
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
