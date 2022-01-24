package ru.gb.course1.l11_menus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_first_container, new FirstFragment())
                    .add(R.id.fragment_second_container, new SecondFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

}