package com.sudhirtheindian4.bubblenavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flarebit.flarebarlib.FlareBar;
import com.flarebit.flarebarlib.Flaretab;
import com.flarebit.flarebarlib.TabEventObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FlareBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setBarBackgroundColor(Color.parseColor("#FFFFFF"));
        ArrayList<Flaretab> tabs = new ArrayList<>();
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.inbox),"Inbox","#FFECB3"));
//
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.search),"Search","#80DEEA"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.phone),"Call Log","#B39DDB"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.person),"Profile","#EF9A9A"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.settings),"Settings","#B2DFDB"));

        bottomBar.setTabList(tabs);
        bottomBar.attachTabs(MainActivity.this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new InboxFragment());
        transaction.commit();


        bottomBar.setTabChangedListener(new TabEventObject.TabChangedListener() {
            @Override
            public void onTabChanged(LinearLayout selectedTab, int selectedIndex, int oldIndex) {
                //tabIndex starts from 0 (zero). Example : 4 tabs = last Index - 3
                Toast.makeText(MainActivity.this,"Tab "+ selectedIndex+" Selected.",Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                //// conainer ek place hai jisme ham algg alag fragmnt ko replace karte hai
                switch (selectedIndex){
                    case 0:

                        transaction.replace(R.id.container,new InboxFragment());
                        break;

                    case 1:
                        transaction.replace(R.id.container,new SearchFragment());



                        break;

                    case 2:
                        transaction.replace(R.id.container,new CallFragment());



                        break;

                    case 3:
                        transaction.replace(R.id.container,new ProfileFragment());



//                        Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        transaction.replace(R.id.container,new SettingFragment());



                        break;
                }
                transaction.commit();


            }
        });




    }
}