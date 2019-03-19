package yqx.com.example.ajwlf.cotton.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import yqx.com.example.ajwlf.cotton.MainActivity;
import yqx.com.example.ajwlf.cotton.R;
import yqx.com.example.ajwlf.cotton.SharedHelper;

public class Fragment_person extends Fragment {

    private Button confirm;
   public PopupMenu popupMenu;
   public ImageButton imageButton ;
   private EditText editText;
   private EditText editText_1;
   private EditText editText_2;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person, container, false);
        imageButton = view .findViewById(R.id.popup_menu);
         editText = view .findViewById(R.id.popup_edit);
         editText_1 = view.findViewById(R.id.editText_1);
         editText_2 = view.findViewById(R.id.editText_2);

         confirm = view.findViewById(R.id.person_confirm);
         confirm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               save();

                 getActivity().onBackPressed();

             }
         });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popu();

            }
        });
        return view;

    }
    public void save()
    {

      SharedHelper sharedHelper = new SharedHelper(getContext());
   //   sharedHelper.save("yqx","178615802607","ssss");

       // editText.setText(editText.getText().toString());editText_1.setText(editText_1.getText().toString());
       // editText_2.setText(editText_2.getText().toString());


      sharedHelper.save(editText_2.getText().toString(),editText_1.getText().toString(),editText.getText().toString());
    }
    public void popu()
    {
      popupMenu = new PopupMenu(getContext(),imageButton);
       popupMenu.getMenuInflater().inflate(R.menu.menu_pop,popupMenu.getMenu());
       popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {

               switch (item.getItemId())
               {
                   case R.id.west:
                  editText.setText("华西地区");break;
                   case R.id.east:
                       editText.setText("华东地区");break;
                   case R.id.south:
                       editText.setText("华南地区");break;
                   case R.id.north:
                       editText.setText("华北地区");break;
               }
               return true;
           }
       });
       popupMenu.show();
    }
}
