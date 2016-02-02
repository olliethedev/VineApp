package com.lex.vinepopular.adapters;

/**
 * Created by Oleksiy on 1/31/2016.
 */
public class ItemBinder<T> {
    private int layoutItemId, bindId;

    public ItemBinder(int layoutItemId, int bindId) {
        this.layoutItemId = layoutItemId;
        this.bindId = bindId;
    }

    public int getLayoutItemId() {
        return layoutItemId;
    }

    public int getBindId() {
        return bindId;
    }
}
