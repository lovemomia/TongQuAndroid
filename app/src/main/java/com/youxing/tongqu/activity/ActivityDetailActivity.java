package com.youxing.tongqu.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.youxing.common.adapter.GroupStyleAdapter;
import com.youxing.tongqu.R;
import com.youxing.tongqu.app.TQActivity;

/**
 * Created by Jun Deng on 15/6/5.
 */
public class ActivityDetailActivity extends TQActivity {

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        ListView listView = (ListView)findViewById(R.id.listView);
        adapter = new Adapter();
        listView.setAdapter(adapter);
    }

    class Adapter extends GroupStyleAdapter {

        public Adapter() {
            super(ActivityDetailActivity.this);
        }

        @Override
        public int getCountInSection(int section) {
            if (section == 2) {
                return 3;
            } else if (section == 3) {
                return 2;
            }
            return 1;
        }

        @Override
        public int getSectionCount() {
            return 5;
        }

        @Override
        public View getViewForRow(View convertView, ViewGroup parent, int section, int row) {
            View view = null;
            if (section == 0) {
                view = LayoutInflater.from(ActivityDetailActivity.this).inflate(R.layout.layout_activity_detail_header, null);
            } else if (section == 1) {
                view = LayoutInflater.from(ActivityDetailActivity.this).inflate(R.layout.layout_activity_detail_attenders, null);
            } else if (section == 2) {
                view = LayoutInflater.from(ActivityDetailActivity.this).inflate(R.layout.layout_activity_detail_info, null);
            } else if (section == 3) {
                view = LayoutInflater.from(ActivityDetailActivity.this).inflate(R.layout.layout_activity_detail_intro, null);
            } else if (section == 4) {
                view = LayoutInflater.from(ActivityDetailActivity.this).inflate(R.layout.layout_activity_detail_daren, null);
            }
            return view;
        }

        @Override
        public View getViewForSection(View convertView, ViewGroup parent, int section) {
            if (section >= 3) {
                View view = LayoutInflater.from(ActivityDetailActivity.this).inflate(R.layout.layout_section_text, null);
                return view;
            }
            return super.getViewForSection(convertView, parent, section);
        }

        @Override
        public int getHeightForSectionView(int section) {
            if (section == 0) {
                return 0;
            } else if (section >= 3) {
                return -1;
            }
            return super.getHeightForSectionView(section);
        }

    }

}
