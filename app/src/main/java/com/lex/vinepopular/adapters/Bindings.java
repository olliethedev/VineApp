package com.lex.vinepopular.adapters;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class Bindings {
    @android.databinding.BindingAdapter(value = {"items", "itemBinding", "layoutManager"})
    public static void showItemsList(RecyclerView recyclerView, List items, ItemBinder itemBinding, RecyclerView.LayoutManager layoutManager) {

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new com.lex.vinepopular.adapters.BindingAdapter(items, itemBinding.getLayoutItemId(), itemBinding.getBindId()));
    }

    @android.databinding.BindingAdapter(value = {"imageUrl", "placeholder"}, requireAll = false)
    public static void loadImage(ImageView imageView, String imageUrl, Drawable drawable) {
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(drawable).into(imageView);
    }

}
