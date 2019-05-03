package com.example.ankurbaranwal.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter
{
    Context ct;
    ArrayList<User> a1;

    public MyAdapter(Context ct, ArrayList<User> a1) {
        this.ct = ct;
        this.a1 = a1;
    }

    @Override
    public int getCount() {
        return a1.size();
    }

    @Override
    public Object getItem(int i) {
        return a1.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Activity at = (Activity) ct;


        View v1 = at.getLayoutInflater().inflate(R.layout.mylayout,null);

        User u = (User) getItem(i);

        ImageView iv = v1.findViewById(R.id.im1);
        TextView tv = v1.findViewById(R.id.tx1);
        TextView tv1 = v1.findViewById(R.id.tx2);

        iv.setImageResource(u.getImage());

        tv.setText(u.getName());
        tv1.setText(u.getReg());

        return v1;
    }
}
