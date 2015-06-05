package com.youxing.tongqu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;

import com.youxing.tongqu.R;
import com.youxing.tongqu.app.TQActivity;

/**
 * Created by Jun Deng on 15/6/4.
 */
public class ActivityManagerActivity extends TQActivity {

    private FragmentTabHost tabHost = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        tabHost.addTab(tabHost.newTabSpec("0").setIndicator("招募中"), ActivityListFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("1").setIndicator("待发布"), ActivityListFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("2").setIndicator("已完成"), ActivityListFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("3").setIndicator("已取消"), ActivityListFragment.class, null);

        tabHost.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItemCompat.setShowAsAction(menu.add("添加"),
                MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ("添加".equals(item.getTitle())) {

        }
        return super.onOptionsItemSelected(item);
    }

}
