package com.lex.vinepopular.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class BindingAdapter extends RecyclerView.Adapter<BindingAdapter.BindingViewHolder> {
    private int itemLayoutId;
    private List data;
    private int bindingVariableId;

    public BindingAdapter(int itemLayoutId, int bindingVariableId) {
        this.itemLayoutId = itemLayoutId;
        this.bindingVariableId = bindingVariableId;
    }

    public BindingAdapter(List data, int itemLayoutId, int bindingVariableId) {
        this.itemLayoutId = itemLayoutId;
        this.data = data;
        this.bindingVariableId = bindingVariableId;
    }

    public void setData(List data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), itemLayoutId, parent, false).getRoot());
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.getBinding().setVariable(bindingVariableId, data.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public static class BindingViewHolder extends RecyclerView.ViewHolder {
        public BindingViewHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return DataBindingUtil.getBinding(itemView);
        }
    }
}
