package yqx.com.example.ajwlf.cotton.AdapterHelper;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import yqx.com.example.ajwlf.cotton.Fragment.Fragment_1;
import yqx.com.example.ajwlf.cotton.Fragment.Fragment_2;
import yqx.com.example.ajwlf.cotton.Fragment.Fragment_3;
import yqx.com.example.ajwlf.cotton.MainActivity;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private Fragment_1 fragment_1 =null;
    private Fragment_2 fragment_2 =null;
    private Fragment_3 fragment_3 =null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2(fm);
        fragment_3 = new Fragment_3(fm);

    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case MainActivity.PAGE_ONE:
                fragment=fragment_1;
                break;


            case MainActivity.PAGE_TWO:
                fragment=fragment_2;
                break;



            case MainActivity.PAGE_THREE:
                fragment=fragment_3;
                break;

        }
        return fragment;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


}
