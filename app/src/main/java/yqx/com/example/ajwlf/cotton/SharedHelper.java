package yqx.com.example.ajwlf.cotton;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SharedHelper {

    private Context mContext;

    public SharedHelper() {
    }

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
    }


    //定义一个保存数据的方法
    public void save(String name, String phone,String area) {
     SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = sp.edit();
       editor.putString("name", name);
       editor.putString("phone", phone);
       editor.putString("area",area);

      editor.apply();
        Toast.makeText(mContext, "信息已写入", Toast.LENGTH_SHORT).show();
    }
public void save_alarm(String lis,String num)
{
    SharedPreferences sp = mContext.getSharedPreferences("my_alarm", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString("lis", lis);
    editor.putString("num", num);
    editor.apply();
    Toast.makeText(mContext, "信息已写入", Toast.LENGTH_SHORT).show();

}

public Map<String, String> read_alarm() {
        Map<String, String> data = new HashMap<String, String>();
        SharedPreferences sp = mContext.getSharedPreferences("my_alarm", Context.MODE_PRIVATE);
        data.put("lis", Objects.requireNonNull(sp.getString("lis", "")));
        data.put("num", Objects.requireNonNull(sp.getString("num", "")));


        return data;
    }
    //定义一个读取SP文件的方法
    public Map<String, String> read() {
        Map<String, String> data = new HashMap<String, String>();
        SharedPreferences sp = mContext.getSharedPreferences("mysp", Context.MODE_PRIVATE);
        data.put("name", Objects.requireNonNull(sp.getString("name", "")));
        data.put("phone", Objects.requireNonNull(sp.getString("phone", "")));
        data.put("area", Objects.requireNonNull(sp.getString("area", "")));

        return data;
    }

}