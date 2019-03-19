package yqx.com.example.ajwlf.cotton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import yqx.com.example.ajwlf.cotton.AdapterHelper.MyFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity implements  RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener {

    private MyFragmentPagerAdapter mAdapter;
    private TextView title;
    private RadioGroup radioGroup ;
    private RadioButton radioButton_1;
    private RadioButton radioButton_2;
    private RadioButton radioButton_3;
   private ViewPager viewPager;
   public ListView person;
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;


    private static final int PHOTO_REQUEST_CUT=0;
    private static final int PHOTO_REQUEST_GALLERY = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        bindView();
        radioButton_1.setChecked(true);
    }

   public void bindView()
   {
         title = findViewById(R.id.title);
         radioGroup = (RadioGroup) findViewById(R.id.botton_bar);
         radioButton_1 = (RadioButton) findViewById(R.id.button);
         radioButton_2 = (RadioButton)findViewById(R.id.button1);
         radioButton_3 = (RadioButton)findViewById(R.id.button2);
         radioGroup.setOnCheckedChangeListener(this);

       viewPager = (ViewPager) findViewById(R.id.vpager);
       viewPager.setAdapter(mAdapter);
       viewPager.setCurrentItem(0);
       viewPager.setOnPageChangeListener(this);


   }
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
      //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (viewPager.getCurrentItem()) {
                case PAGE_ONE:
                    title.setText("记录");
                    radioButton_1.setChecked(true);
                    break;
                case PAGE_TWO:
                    title.setText("查看");
                    radioButton_2.setChecked(true);
                    break;
                case PAGE_THREE:
                    title.setText("个人中心");
                    radioButton_3.setChecked(true);
                    break;
            }
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
         switch (checkedId)
         {
             case R.id.button:
                 title.setText("记录");
                 viewPager.setCurrentItem(PAGE_ONE);
                   break;
             case R.id.button1:
                 title.setText("查看");
                 viewPager.setCurrentItem(PAGE_TWO);
                 break;
             case R.id.button2:
                 title.setText("个人中心");
                 viewPager.setCurrentItem(PAGE_THREE);
                 break;

         }
    }





    public void changePictrue(View v)
    {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,PHOTO_REQUEST_GALLERY);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==PHOTO_REQUEST_GALLERY)
        {
            if(data!=null) {
                Uri uri = data.getData();
                crop(uri);
            }
        }
        else
        {
           if(requestCode==PHOTO_REQUEST_CUT)
            {
                if(data!=null)
                {
                    Bitmap bitmap = data.getParcelableExtra("data");

                    save(bitmap);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void save (Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,80,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String imageString = Base64.encodeToString(bytes, Base64.DEFAULT);
        SharedPreferences sharedPreferences =getSharedPreferences("testSP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("image", imageString);
        editor.apply();
        mAdapter.notifyDataSetChanged();
    }
    public void crop(Uri uri)
    {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");

        intent.putExtra("crop","true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        intent.putExtra("circle",true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }




}
