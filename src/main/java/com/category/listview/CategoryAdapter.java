package com.category.listview;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by jiaowenzheng on 2014/12/30.
 */
public class CategoryAdapter extends BaseAdapter {

    private String[] mMenu = new String[]{};
    private LayoutInflater mLayoutInflater;
    private int mIndex = -1;

    public CategoryAdapter(Context context,String[] menu){
        this.mMenu = menu;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setViewBackGround(int index){
        this.mIndex = index;
    }

    @Override
    public int getCount() {
        return mMenu.length;
    }

    @Override
    public Object getItem(int i) {
        return mMenu[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.listview_item,null);
            viewHolder.textView = (TextView) view.findViewById(R.id.text);
            viewHolder.tv_head = (TextView) view.findViewById(R.id.tv_head);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        if(i == mIndex){
            view.setBackgroundColor(Color.rgb(237,237,237));
            viewHolder.textView.setTextColor(Color.GREEN);
            viewHolder.tv_head.setBackgroundColor(Color.RED);

        }else{
            view.setBackgroundColor(Color.WHITE);
            viewHolder.textView.setTextColor(Color.BLACK);
            viewHolder.tv_head.setBackgroundColor(Color.WHITE);
        }

        viewHolder.textView.setText(mMenu[i]);
        return view;
    }

    class ViewHolder{
        TextView textView;
        TextView tv_head;
    }
}
