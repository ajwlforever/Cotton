package yqx.com.example.ajwlf.cotton.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import yqx.com.example.ajwlf.cotton.R;

public class Fragment_echarts extends Fragment {

    private WebView webView ;
    private int get;
    private String name;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_echarts, container, false);
       webView = view.findViewById(R.id.webView);
       webView .getSettings().setAllowFileAccess(true);
       webView .getSettings().setJavaScriptEnabled(true);


 int width = getContext().getResources().getDisplayMetrics().widthPixels;

 //if(width>750)webView.setInitialScale(300);
 //else
  if(width>650) webView.setInitialScale(250);
 else if(width<649)webView.setInitialScale(190);


        get=getArguments().getInt("content");
       switch (get)
       {
           case 0:
               name="二氧化碳浓度";
               webView.loadUrl("file:///android_asset/co2.html");
               break;
           case 1:
               name="空气温度";
               webView.loadUrl("file:///android_asset/air_temp.html");
               break;
           case 2:
               name="湿度";
               webView.loadUrl("file:///android_asset/shidu.html");
               break;
           case 3:
               name="风速";
               webView.loadUrl("file:///android_asset/fengsu" +
                       ".html");
               break;
       }
webView.setWebViewClient(new WebViewClient()
{
    public void onPageFinished(WebView webView , String URL)
    {
       if( name.equals("二氧化碳浓度" )) webView.loadUrl("javascript:ctreate_1([89,78,77,79,80,86,90]);");
       else
      if(name.equals("空气温度"))
          webView.loadUrl("javascript:ctreate_1([14,15,16,18,17.5,13,15],[20,30,20,25,27,29,30]);");

        else
             if(name.equals("风速"))webView.loadUrl("javascript:ctreate_1([0.1,0.5,0.8,0.9,0.8,0.7]);");
        else
             webView.loadUrl("javascript:ctreate_1([20,30,20,25,27,29,30]);");



    }
});



        return view;
    }


}
