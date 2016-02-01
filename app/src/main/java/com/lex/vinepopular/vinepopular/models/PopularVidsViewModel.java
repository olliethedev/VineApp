package com.lex.vinepopular.vinepopular.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.v7.widget.GridLayoutManager;

import com.lex.vinepopular.vinepopular.BR;
import com.lex.vinepopular.vinepopular.MyApplication;
import com.lex.vinepopular.vinepopular.R;
import com.lex.vinepopular.vinepopular.adapters.ItemBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class PopularVidsViewModel extends BaseObservable {
    public ObservableField<GridLayoutManager> layoutManager = new ObservableField<>();
    private PopularVidsModel popularVids;
    private ItemBinder<PopularVidsModel> itemBinding;

    public PopularVidsViewModel() {
        layoutManager.set(new GridLayoutManager(MyApplication.getContext(), 3));
        itemBinding = new ItemBinder<>(R.layout.popular_vid_item, BR.recordViewModel);
    }

    @Bindable
    public ItemBinder<PopularVidsModel> getItemBinding() {
        return itemBinding;
    }

    public void setItemBinding(ItemBinder<PopularVidsModel> itemBinding) {
        this.itemBinding = itemBinding;
        notifyPropertyChanged(BR.itemBinding);
    }

    @Bindable
    public PopularVidsModel getPopularVids() {
        return popularVids;
    }

    public void setPopularVids(PopularVidsModel popularVids) {
        this.popularVids = popularVids;
        notifyPropertyChanged(BR.popularVids);
        notifyPropertyChanged(BR.recordViewModels);
    }

    @Bindable
    public List<RecordViewModel> getRecordViewModels() {
        List<RecordViewModel> recordViewModels = new ArrayList<>();
        if (popularVids != null) {
            for (PopularVidsModel.Record r : popularVids.data.records) {
                recordViewModels.add(new RecordViewModel(r));
            }
        }
        return recordViewModels;
    }
}
