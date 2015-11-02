package com.category.listview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月2日09:37:58
 * Description:  关于内容更新的适配器
 */
public class ContentAdapter extends BaseAdapter {

    private String[] mMenu = new String[]{};
    private LayoutInflater mLayoutInflater;
    private int mIndex = -1;

    public ContentAdapter(Context context, String[] menu){
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
            viewHolder.iv_content_image = (ImageView) view.findViewById(R.id.iv_content_image);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        if(i == mIndex){
            view.setBackgroundColor(Color.WHITE);
            viewHolder.textView.setTextColor(Color.GREEN);
        }else{
            view.setBackgroundColor(Color.DKGRAY);
            viewHolder.textView.setTextColor(Color.RED);
        }

        viewHolder.textView.setText(mMenu[i]);
        return view;
    }

    class ViewHolder{
        TextView textView;
        ImageView iv_content_image;
    }
}
