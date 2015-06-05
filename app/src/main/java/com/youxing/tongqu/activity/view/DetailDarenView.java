package com.youxing.tongqu.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youxing.common.views.YXNetworkImageView;
import com.youxing.tongqu.R;

/**
 * Created by Jun Deng on 15/6/5.
 */
public class DetailDarenView extends LinearLayout {

    private YXNetworkImageView photoIv;
    private TextView introTv;

    public DetailDarenView(Context context) {
        this(context, null);
    }

    public DetailDarenView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        photoIv = (YXNetworkImageView)findViewById(R.id.daren_photo);
        introTv = (TextView)findViewById(R.id.daren_intro);
    }
}
