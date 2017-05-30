package com.example.roach.zun;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.maingroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Fragment fragment = null;

                Class fragmentClass = null;
                Bundle bundle=new Bundle();
                switch (checkedId) {
                    case -1:
                        break;
                    case R.id.radioSport:
                        fragmentClass= MainFragment.class;
                        bundle.putString("class","sport");
                        // TODO: 31.05.2017 фрагмент фнкеты спорта
                        break;
                    case R.id.radioProf:
                        // TODO: 31.05.2017 фрагмент анкеты профессии
                        break;
                    case R.id.radioArt:
                        // TODO: 31.05.2017  фрагмент анкеты творчества
                        break;

                    default:
                        break;
                }

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fragment.setArguments(bundle);
                // Вставляем фрагмент, заменяя текущий фрагмент
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.testFrame, fragment).commit();
            }
        });
    }
}
