package yqx.com.example.ajwlf.cotton.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import yqx.com.example.ajwlf.cotton.AdapterHelper.BaseAdapterHelper_2;
import yqx.com.example.ajwlf.cotton.R;

@SuppressLint("ValidFragment")
public class Fragment_2 extends Fragment {
    private FragmentManager fm;
    private FragmentTransaction fTransaction;
   private  Fragment_echarts ncFragment;
    @SuppressLint("ValidFragment")
    public Fragment_2(FragmentManager fragmentManager)
    {
        super();
        fm=fragmentManager;
    }
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        ListView listView = view.findViewById(R.id.mylist);
        listView.setAdapter(new BaseAdapterHelper_2(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               fTransaction = fm.beginTransaction();
              ncFragment = new Fragment_echarts();
                Bundle bd = new Bundle();
                bd.putInt("content",position);
                ncFragment.setArguments(bd);

                //TODO 动画
               fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
               fTransaction.replace(R.id.fl_content, ncFragment);
                //调用addToBackStack将Fragment添加到栈中
                fTransaction.addToBackStack(null);
                fTransaction.commit();
            }
        });
        return view;
    }


}
