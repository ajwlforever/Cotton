package yqx.com.example.ajwlf.cotton.AdapterHelper;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

import yqx.com.example.ajwlf.cotton.R;

public class BaseAdapterHelper_2 extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private Vector<String> data = new Vector<String>();
    private int[] dr={
            R.drawable.co,
            R.drawable.wendu,
            R.drawable.shidu,
            R.drawable.fengsu
    } ;
    private ImageView imageView;
    private TextView textView;


    public BaseAdapterHelper_2(Context context){
        this.context=context;
        data.add("二氧化碳浓度");
        data.add("空气温度");
        data.add("空气湿度");
        data.add("风速");
        this.layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.adapter_2, null);
        // TODO 优化
            textView = convertView.findViewById(R.id.text);
            imageView = convertView.findViewById(R.id.image);
            textView.setText(data.get(position));
           imageView.setImageResource(dr[position]);

        return convertView;
    }
}
