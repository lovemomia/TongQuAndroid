package com.youxing.tongqu.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.youxing.common.adapter.BasicAdapter;
import com.youxing.tongqu.R;
import com.youxing.tongqu.activity.view.ActivityListItem;
import com.youxing.tongqu.app.TQFragment;

/**
 * Created by Jun Deng on 15/6/4.
 */
public class ActivityListFragment extends TQFragment implements AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout swipeLayout;
    private ListView listView;
    private Adapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list, null);
        listView = (ListView)view.findViewById(R.id.listView);
        adapter = new Adapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        swipeLayout = (SwipeRefreshLayout)view.findViewById(R.id.refresh);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        return view;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);
            }
        }, 2000);
    }

    class Adapter extends BasicAdapter {

        private Object ITEM = new Object();

        @Override
        public Object getItem(int position) {
            return ITEM;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (getItem(position) == ITEM) {
                if (!(view instanceof ActivityListItem)) {
                    view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_activity_list_item, null);
                }
                ((ActivityListItem)view).setData();
            }

            return view;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tq://activitydetail")));
    }
}
