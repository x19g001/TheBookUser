package com.example.thebookuser.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thebookuser.R;

public class ListViewAdapter2 extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    private final LayoutInflater inflater;
    private final int itemLayoutId;
    private final String[] titles;
    private int[] ids;
    //
    public ListViewAdapter2(Context context, int itemLayoutId,
                           String[] scenes, int[] photos) {
        super();
        this.inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.titles = scenes;
        this.ids = photos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewAdapter2.ViewHolder holder2;
        // 最初だけ View を inflate して、それを再利用する
        if (convertView == null) {
            // activity_main.xml に list.xml を inflate して convertView とする
            convertView = inflater.inflate(itemLayoutId, parent, false);
            // ViewHolder を生成
            holder2 = new ListViewAdapter2.ViewHolder();
            holder2.textView=convertView.findViewById(R.id.textView1);
            holder2.imageView = convertView.findViewById(R.id.imageView1);
            convertView.setTag(holder2);

            if(position==0){
                // 背景色を変える
                convertView.setBackgroundColor(Color.rgb(135, 206, 235));
            }
        }

        // holder を使って再利用
        else {
            holder2 = (ListViewAdapter2.ViewHolder) convertView.getTag();
        }

        holder2.imageView.setImageResource(ids[position]);
        // 現在の position にあるファイル名リストを holder の textView にセット
        holder2.textView.setText(titles[position]);
        return convertView;
    }

    @Override
    public int getCount() {
        // texts 配列の要素数
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

