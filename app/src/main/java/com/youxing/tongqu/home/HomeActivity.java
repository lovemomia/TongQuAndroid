package com.youxing.tongqu.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.youxing.common.adapter.GroupStyleAdapter;
import com.youxing.tongqu.R;
import com.youxing.tongqu.app.TQActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends TQActivity implements AdapterView.OnItemClickListener {

    private Adapter adapter;

    private List<GridMenu> menus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView = (ListView)findViewById(R.id.listView);
        adapter = new Adapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position < menus.size()) {
            GridMenu menu = menus.get(position);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(menu.action)));
        }
    }

    private void setGridView(GridView grid) {
        menus.add(new GridMenu(R.drawable.user, "订单管理", "tq://orderlist"));
        menus.add(new GridMenu(R.drawable.user, "活动管理", "tq://activitylist"));
        menus.add(new GridMenu(R.drawable.user, "活动日程", "tq://activitydate"));
        menus.add(new GridMenu(R.drawable.user, "场地预约", "tq://placebook"));
        menus.add(new GridMenu(R.drawable.user, "用户评价", "tq://userfeedback"));
        menus.add(new GridMenu(R.drawable.user, "我的", "tq://mine"));

        List<Map<String, Object>> lstImageItem = new ArrayList<>();
        for(GridMenu menu : menus)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("image", menu.icon);
            map.put("text", menu.title);
            lstImageItem.add(map);
        }

        SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,
                R.layout.layout_home_grid_item,

                new String[] {"image","text"},

                new int[] {R.id.image,R.id.text});
        grid.setAdapter(saImageItems);
        grid.setOnItemClickListener(this);
    }

    class GridMenu {

        public GridMenu(int icon, String title, String action) {
            this.icon = icon;
            this.title = title;
            this.action = action;
        }

        int icon;
        String title;
        String action;
    }

    class Adapter extends GroupStyleAdapter {

        public Adapter() {
            super(HomeActivity.this);
        }

        @Override
        public int getCountInSection(int section) {
            return 1;
        }

        @Override
        public int getSectionCount() {
            return 2;
        }

        @Override
        public View getViewForRow(View convertView, ViewGroup parent, int section, int row) {
            View view = null;
            if (section == 0) {
                view = LayoutInflater.from(HomeActivity.this).inflate(R.layout.layout_home_header, null);
            } else {
                GridView gridview = (GridView) LayoutInflater.from(HomeActivity.this).inflate(R.layout.layout_home_grid, null);
                setGridView(gridview);
                view = gridview;
            }
            return view;
        }
    }
}
