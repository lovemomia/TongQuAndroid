package com.youxing.tongqu.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youxing.common.views.YXNetworkImageView;
import com.youxing.tongqu.R;

/**
 * Created by Jun Deng on 15/6/5.
 */
public class ActivityListItem extends RelativeLayout {

    private YXNetworkImageView iconIv;
    private TextView titleTv;
    private TextView dateTv;
    private TextView numTv;
    private TextView priceTv;

    public ActivityListItem(Context context) {
        this(context, null);
    }

    public ActivityListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActivityListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        iconIv = (YXNetworkImageView)findViewById(R.id.icon);
        titleTv = (TextView)findViewById(R.id.title);
        dateTv = (TextView)findViewById(R.id.date);
        numTv = (TextView)findViewById(R.id.num);
        priceTv = (TextView)findViewById(R.id.price);
    }

    public void setData() {
        // TODO
        iconIv.setImageUrl("http://maitian.qiniudn.com/cefc83e5-d840-47c0-a467-939777f4779c.jpg?imageView2/1/w/240/h/180/q/80/format/jpg");
    }
}
