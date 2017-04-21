package com.example.onuchinx.moxy.ui.views;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class FrameSwipeRefreshLayout extends SwipeRefreshLayout {
    private ListView mListViewChild;

    public FrameSwipeRefreshLayout(Context context) {
        super(context);
    }

    public FrameSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setListViewChild(ListView listViewChild) {
        mListViewChild = listViewChild;
    }

    @Override
    public boolean canChildScrollUp() {
        if (mListViewChild != null && mListViewChild.getVisibility() == VISIBLE) {
            return mListViewChild.canScrollVertically(-1);
        }

        return super.canChildScrollUp();
    }
}
