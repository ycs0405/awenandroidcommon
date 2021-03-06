package com.mozhuowen.widget.views.tableview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import net.datafans.android.common.widget.table.TableViewDataSource;
import net.datafans.android.common.widget.table.TableViewStyle;
import net.datafans.android.common.widget.table.refresh.RefreshControlType;

public class PlainTableView<T> extends TableView<T> {

    protected PlainTableView(Context context, RefreshControlType type,
                             boolean enableRefresh, boolean enableLoadMore,
                             boolean enableAutoLoadMore, TableViewDataSource<T> dataSource, TableViewDelegate delegate,View headerView) {
        super(context, type, enableRefresh, enableLoadMore, enableAutoLoadMore, TableViewStyle.PLAIN, dataSource, delegate,headerView);

        getAdapter().getListView().setDivider(new ColorDrawable(Color.rgb(216,216,216)));
        getAdapter().getListView().setDividerHeight(1);
    }


    public static class Builder<T> extends TableView.Builder<T>{

        public PlainTableView<T> build(){

            return new PlainTableView<>(getContext(), getRefreshType(), isEnableRefresh(), isEnableLoadMore(), isEnableAutoLoadMore(), getDataSource(), getDelegate(),getHeaderView());

        }
    }

}
