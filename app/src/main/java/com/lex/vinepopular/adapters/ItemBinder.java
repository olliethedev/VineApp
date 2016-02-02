package com.lex.vinepopular.adapters;

import android.support.annotation.LayoutRes;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class ItemBinder<T> {
    private int layoutItemId, boundVariableId;

    public ItemBinder(@LayoutRes int layoutItemId, int bindId) {
        this.layoutItemId = layoutItemId;
        this.boundVariableId = bindId;
    }

    public int getLayoutItemId() {
        return layoutItemId;
    }

    public int getBoundVariableId() {
        return boundVariableId;
    }
}
