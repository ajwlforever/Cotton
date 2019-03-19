package yqx.com.example.ajwlf.cotton.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import yqx.com.example.ajwlf.cotton.MainActivity;
import yqx.com.example.ajwlf.cotton.R;
import yqx.com.example.ajwlf.cotton.SharedHelper;

@SuppressLint("ValidFragment")
public class Fragment_3 extends Fragment {
    private ArrayList<String> data = new ArrayList<String>();
    private ImageView imageView;
    private ListView listView_1;
    private ListView listView_2;
    private FragmentTransaction fTransaction;
    private  FragmentManager fm;
   private Fragment_person ncFragment;

   private TextView user_name;
   private TextView user_val;
   private ProgressDialog p1;
   private ProgressDialog p2 ;

   private Button alarm_confirm;

   private  ArrayAdapter<String> adapter;
@SuppressLint("HandlerLeak")
 private Handler handler = new Handler()
{
    public void handleMessage(Message msg)
    {
        if (msg.what==0x123)
        {

            p1.dismiss();
            p2 = new ProgressDialog(getActivity());
            p2.setTitle("版本更新信息");
            p2.setMessage("您的版本是1.0.1，已是最新版本!");
            p2.show();
        }
    }
};


    public Fragment_3(FragmentManager fragmentManager)
    {
        super();
        fm=fragmentManager;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        imageView = view.findViewById(R.id.user);
        listView_1 = view .findViewById(R.id.person);
        listView_2 = view.findViewById(R.id.app);
        user_name = view.findViewById(R.id.user_name);
        user_val = view.findViewById(R.id.user_val);

       listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        change_person();
                        break;

                    case 1:
                        set_Alarm();
                        break;
                    case 2:
                       link_us();
                        break;

                }
            }
        });
  listView_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          switch (position)
          {
              case 0:
                  update();
                  break;

              case 1:
                  set();
                  break;


          }
      }
  });

        return view;
    }

    public void set()
    {

    }
    public void update()
    {
        p1 = new ProgressDialog(getActivity());
        p1.setTitle("正在检查更新...");
        p1.setCancelable(true);

        p1.setIndeterminate(false);
    new Timer().schedule(new TimerTask()
    {
        @Override
        public void run() {
            handler.sendEmptyMessage(0x123);
        }
    },2000);
        p1.show();
    }
    public void set_Alarm()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final AlertDialog alertDialog
                =
                builder
                .create()
                ;
        alertDialog.show();

        Window win = alertDialog.getWindow();

        assert win != null;
        win.setContentView(R.layout.alarm_set);




        final Spinner spinner_1 = win.findViewById(R.id.spin_one);
        final Spinner spinner_2 = win.findViewById(R.id.spin_two);
        adapter = new ArrayAdapter<String>(Objects.requireNonNull(getActivity()),R.layout.spiner,data);
        alarm_confirm = win.findViewById(R.id.alarm_confirm);

        alarm_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = spinner_1.getTransitionName();
                String y =spinner_2.getTransitionName();
                SharedHelper sharedHelper = new SharedHelper(getContext());
                alertDialog.dismiss();
                sharedHelper.save_alarm(x,y);
            }
        });
        co2();
        spinner_2.setAdapter(adapter);

 spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
     @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         switch ( position )
         {
             case 0 :
                 co2();
                 break;
             case 1:
                 air_temp();
                 break;
             case 2:
                 air_shidu();
                 break;
             case 3:
                fengsu();
                break;
         }
     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }
 });


    }



    public void co2() {
        adapter.clear();
        data.add("800 μmol/mol");
        data.add("500 μmol/mol");
        data.add("1000 μmol/mol");
        data.add("1500 μmol/mol");
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }
    public void air_temp()
    {
        adapter.clear();
        data.add("14 摄氏度");
        data.add("25 摄氏度");
        data.add("31 摄氏度");
        data.add("37 摄氏度");
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }
    public void air_shidu()
    {
        adapter.clear();
        data.add("30%"); data.add("40%");
        data.add("75%"); data.add("50%");
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }
    public void fengsu()
    {
        adapter.clear();
        data.add("0.1m/s");
        data.add("0.3m/s");
        data.add("0.5m/s");
        data.add("0.7m/s");
        adapter.addAll(data);
        adapter.notifyDataSetChanged();

    }

    public void link_us(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog alertDialog
                =
                builder
                .setIcon(R.drawable.black)
                .setTitle("联系我们")
                .setMessage("客服电话：\n 10086")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "出问题记得联系客服哦!~", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "出问题记得联系客服哦!~", Toast.LENGTH_SHORT).show();
                            }
                        })
                .create();
        alertDialog.show();





    }
    public void  change_person(){
        fTransaction = fm.beginTransaction();

        ncFragment = new Fragment_person();
        Bundle bd = new Bundle();
        bd.putInt("content",0);
        ncFragment.setArguments(bd);

        //TODO 动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_content, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();


    }
    public void  update_touxiang(){
    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("testSP", Context.MODE_PRIVATE);
    String imageString = sharedPreferences.getString("image", "");
    //第二步:利用Base64将字符串转换为ByteArrayInputStream
    byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
    if (byteArray.length == 0) {
        imageView.setImageResource(R.drawable.black);
    } else {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        //第三步:利用ByteArrayInputStream生成Bitmap
        Bitmap bitmap = BitmapFactory.decodeStream(byteArrayInputStream);
        imageView.setImageBitmap(bitmap);


    }
}
    public void onResume(){
      super.onResume();
       update_touxiang();
        read();
    }
   public void read()
   {
       SharedHelper sharedHelper = new SharedHelper(getContext());
       Map<String,String> ss = sharedHelper.read();
       user_name.setText(ss.get("name"));
       user_val.setText(ss.get("phone"));
   }
    }

