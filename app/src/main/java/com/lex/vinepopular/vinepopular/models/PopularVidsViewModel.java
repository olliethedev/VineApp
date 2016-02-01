package com.lex.vinepopular.vinepopular.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.widget.GridLayoutManager;

import com.lex.vinepopular.vinepopular.BR;
import com.lex.vinepopular.vinepopular.MyApplication;
import com.lex.vinepopular.vinepopular.R;
import com.lex.vinepopular.vinepopular.adapters.ItemBinder;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class PopularVidsViewModel extends BaseObservable {
    public ObservableField<PopularVids> popularVids = new ObservableField<>();
    public ObservableField<GridLayoutManager> layoutManager = new ObservableField<>();
    private ItemBinder<PopularVids> itemBinding;

    public PopularVidsViewModel() {
        layoutManager.set(new GridLayoutManager(MyApplication.getContext(), 3));
        itemBinding = new ItemBinder<>(R.layout.popular_vid_item, BR.record);
    }

    @Bindable
    public ItemBinder<PopularVids> getItemBinding() {
        return itemBinding;
    }

    public void setItemBinding(ItemBinder<PopularVids> itemBinding) {
        this.itemBinding = itemBinding;
        notifyPropertyChanged(BR.itemBinding);
    }
}
