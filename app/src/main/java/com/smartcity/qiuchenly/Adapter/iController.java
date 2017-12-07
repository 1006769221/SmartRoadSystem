package com.smartcity.qiuchenly.Adapter;

import android.view.View;
import android.widget.TextView;

/**
 * Created by qiuchenly on 2017/12/7.
 */

public interface iController {

    interface iPersonalEvent {
        void PersonSetViewEvent(View v, int p);
    }

    interface iPersonPageChanged {
        void PersonPageChangedEvent(int p);
    }

    interface iContentPageChanged {
        TextView getContentTitleView(int position);
    }

    interface iContentViewPagerViewEvent {
        //初始化每一个View的事件bind
        void setViewEvent(int i, View view);
    }

}
