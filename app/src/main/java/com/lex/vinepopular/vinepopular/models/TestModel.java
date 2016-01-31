package com.lex.vinepopular.vinepopular.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.lex.vinepopular.vinepopular.BR;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class TestModel extends BaseObservable {
    private String name;
    private String imageUrl;

//    @BindingAdapter({"imageUrl", "placeholder"})
//    public static void loadImage(ImageView imageView, String imageUrl, Drawable drawable) {
//        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(drawable).into(imageView);
//    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }
}
