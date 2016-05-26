package com.mozhuowen.rxandroid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mozhuowen.rxandroid.ui.Toolbar;
import com.mozhuowen.rxandroid.ui.ToolbarDefault;
import com.mozhuowen.rxandroid.ui.handlers.ActionBarHandler;

/**
 * Created by Awen on 16/5/26.
 * Email:mozhuowen@gmail.com
 */
public abstract class ToolBarFragment extends BaseFragment  {

    private ActionBarHandler mActionBarHandler;
    private Toolbar mCustomToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) super.onCreateView(inflater,container,savedInstanceState);

        if (enableActionBar()) {
            mActionBarHandler = getActionBarHandler();
            if (mActionBarHandler == null) {
                mCustomToolbar = new ToolbarDefault(getActivity());
            } else
                mCustomToolbar = mActionBarHandler.build();

            view.addView(mCustomToolbar, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mCustomToolbar.getToolbar().setTitle(getTitle());
        }

        if (getMenuResid() > 0)
            mCustomToolbar.getToolbar().inflateMenu(getMenuResid());

        return view;
    }

    protected abstract boolean enableActionBar();
    protected abstract ActionBarHandler getActionBarHandler();
    protected abstract String getTitle();
    protected abstract int getMenuResid();
}
