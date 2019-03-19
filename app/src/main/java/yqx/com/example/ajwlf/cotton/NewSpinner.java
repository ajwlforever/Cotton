package yqx.com.example.ajwlf.cotton;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class NewSpinner extends android.support.v7.widget.AppCompatSpinner implements AdapterView.OnItemClickListener {

    private ArrayList<String> data = new ArrayList<String>();
    public NewSpinner(Context context) {
        super(context);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     switch (position)
     {
         case 0 :
             co2();
             bindView();
             break;
         case 1:
             air_temp();
             bindView();
             break;
         case 2:
             air_shidu();
             bindView();
         case 3:
             fengsu();
             bindView();

     }
    }
    public void co2() {
        data.add("800 μmol/mol");
        data.add("500 μmol/mol");
        data.add("1000 μmol/mol");
        data.add("1500 μmol/mol");

    }
    public void air_temp()
    {
        data.add("14 摄氏度");
        data.add("25 摄氏度");
        data.add("31 摄氏度");
        data.add("37 摄氏度");

    }
    public void air_shidu()
    {

        data.add("30%"); data.add("40%");
        data.add("75%"); data.add("50%");

    }
    public void fengsu()
    {
        data.add("0.1m/s");
        data.add("0.3m/s");
        data.add("0.5m/s");
        data.add("0.7m/s");


    }
    public void bindView()
    {
        BaseAdapter baseAdapter = new BaseAdapter() {
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

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                TextView textView = new TextView(getContext());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.addView(textView);
                textView.setText(data.get(position));
                return linearLayout;
            }
        };
        this.setAdapter(baseAdapter);
    }
}
