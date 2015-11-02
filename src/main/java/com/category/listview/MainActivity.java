package com.category.listview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    public static final String TAG = "MainActivity";

    private CategoryAdapter mCategoryAdapter;
    private MyListView mMenuListView;
    private MyListView mContentListView;
    private static final String[] mMenus =
            {"常用分类", "服饰内衣", "鞋靴", "手机", "家用电器", "数码",
                    "个护化妆", "图书", "鞋靴", "手机", "家用电器", "数码", "电脑办公"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMenuListView = (MyListView) findViewById(R.id.menu_list);
        mContentListView = (MyListView) findViewById(R.id.menu_list_content);

        mCategoryAdapter = new CategoryAdapter(this, mMenus);
        mMenuListView.setAdapter(mCategoryAdapter);

        mMenuListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        smoothScroollListView(position);
        mCategoryAdapter.setViewBackGround(position);
        mCategoryAdapter.notifyDataSetChanged();
    }

    /**
     * listView scroll
     * @param position
     */
    public void smoothScroollListView(int position){
        if (Build.VERSION.SDK_INT >= 21) {
            mMenuListView.setSelectionFromTop(position,0);
        } else if (Build.VERSION.SDK_INT >= 11) {
            mMenuListView.smoothScrollToPositionFromTop(position,0,500);
        } else if (Build.VERSION.SDK_INT >= 8) {
            int firstVisible = mMenuListView.getFirstVisiblePosition();
            int lastVisible = mMenuListView.getLastVisiblePosition();

            Log.i(TAG, " firstVisible " + firstVisible + " lastVisible " + lastVisible + "  position " + position);

            if (position < firstVisible) {
                mMenuListView.smoothScrollToPosition(position);
            } else {
                if (firstVisible == 0) {
                    mMenuListView.smoothScrollToPosition(position + lastVisible - firstVisible);
                } else {
                    mMenuListView.smoothScrollToPosition(position + lastVisible - firstVisible - 1);
                }
            }
        } else {
            mMenuListView.setSelection(position);
        }

        String[] items = new String[(position + 1) * 2];
        for (int i = 0; i < items.length; i++) {
            items[i] = mMenus[position] + "中的数据：" + i;
        }
        mContentListView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items));
    }

}
