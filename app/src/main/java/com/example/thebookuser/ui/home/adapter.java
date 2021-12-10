//package com.example.thebookuser.ui.home;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class adapter extends BaseAdapter {
//    private LayoutInflater inflater;
//    private int layoutID;
//    private String[] booknamelist;
//    private String[] isbnlist;
//    private Bitmap[] photolist;
//
//    static class ViewHolder {
//        TextView text;
//        TextView isbn;
//        ImageView img;
//    }
//
//    adapter(Context context, int itemLayoutId,
//            String[] names, String[] isbn, int[] photos) {
//
//        inflater = LayoutInflater.from(context);
//        layoutID = itemLayoutId;
//
//        booknamelist = names;
//        isbnlist = isbn;
//        // bitmapの配列
//        photolist = new Bitmap[photos.length];
//        // drawableのIDからbitmapに変換
//        for (int i = 0; i < photos.length; i++) {
//            photolist[i] = BitmapFactory.decodeResource(context.getResources(), photos[i]);
//        }
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder holder;
//
//        if (convertView == null) {
//            convertView = inflater.inflate(layoutID, null);
//            holder = new ViewHolder();
//            holder.img = convertView.findViewById(R.id.img_item);
//            holder.text = convertView.findViewById(R.id.text_view);
//            holder.isbn = convertView.findViewById(R.id.text_isbn);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        holder.img.setImageBitmap(photolist[position]);
//
//        String str = "ID.170900" + String.valueOf(position + 1)
//                + "\n\nisbn: " + isbnlist[position]
//                + "\nTel: 020-8931-9933 #340" + String.valueOf(position+1);
//        holder.isbn.setText(str);
//
//        holder.text.setText(booknamelist[position]);
//
//        return convertView;
//    }
//
//    @Override
//    public int getCount() {
//        return booknamelist.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//}
