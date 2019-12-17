package com.example.recycleviewpartone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ItemsAdapter adapter;
    List<Items> items;
    ConstraintLayout MainLayout;
    RecyclerView recyclerView;

    boolean NightMode = false;

    CharSequence search = "";
    EditText searchView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FloatingActionButton floatingActionButton = findViewById(R.id.FloatingButton);


        MainLayout = findViewById(R.id.MainActivity);
        recyclerView = findViewById(R.id.RecycleView);
        items = new ArrayList<>();
        searchView = findViewById(R.id.search);


        //Load night mode
        NightMode = getThemeState();
        if (NightMode) {
            MainLayout.setBackgroundColor(getResources().getColor(R.color.black));
            floatingActionButton.setImageResource(R.drawable.ic_wb_sunny_black_24dp);
            searchView.setBackgroundResource(R.drawable.search_black);
            searchView.setHint("Search");
        } else {
            MainLayout.setBackgroundColor(getResources().getColor(R.color.white));
            floatingActionButton.setImageResource(R.drawable.ic_brightness_2_black_24dp);
            searchView.setBackgroundResource(R.drawable.search_white);
            searchView.setHint("Search");
        }

        //Floating button on Click event
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NightMode = !NightMode;
                if (NightMode) {
                    MainLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    floatingActionButton.setImageResource(R.drawable.ic_wb_sunny_black_24dp);
                    searchView.setBackgroundResource(R.drawable.search_black);
                    searchView.setHint("Search");
                } else {
                    MainLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    floatingActionButton.setImageResource(R.drawable.ic_brightness_2_black_24dp);
                    searchView.setBackgroundResource(R.drawable.search_white);
                    searchView.setHint("Search");

                }

                adapter = new ItemsAdapter(getApplicationContext(), items, NightMode);
                recyclerView.setAdapter(adapter);
                saveThemeState(NightMode);

            }
        });

        adapter = new ItemsAdapter(this, items, NightMode);


//Items list : Title, Description, Date, Image;
        items.add(new Items("Android Submit", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Build anything on Android", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle5));
        items.add(new Items("Submit your idea", " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Start building an app", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Developer guides", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("Sample code", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Get started", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Android Submit", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Quality guidelines", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("Distribute on Google Play", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Get started with", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Material Design", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("Distribute on Google Play", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Advanced Android with Kotlin course", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Google services for Android", " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Latest news", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("Here’s how to watch the 2019 Android Dev Summit! ", " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Distribute on Google Play", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Introducing NDK r21: our first Long Term Support release", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Celebrating 1 year of Google Play's", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("#AskAndroid - Android Dev Summit", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Cyber Link increased revenue with Google", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Android Developers", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("Get started", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Android Submit", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Quality guidelines", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle5));
        items.add(new Items("Distribute on Google Play", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Get started with", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Material Design", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("Distribute on Google Play", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Advanced Android with Kotlin course", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Google services for Android", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Latest news", "Take advantage of the latest Google technologies through a single set of APIs for Android, delivered across Android devices worldwide as part of Google Play services.Start by setting up the Google Play services library", "15 May 2050", R.drawable.recycle5));
        items.add(new Items("Here’s how to watch the 2019 Android Dev Summit! ", " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Distribute on Google Play", "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "15 May 2050", R.drawable.recycle3));
        items.add(new Items("Introducing NDK r21: our first Long Term Support release", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Celebrating 1 year of Google Play's", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));
        items.add(new Items("#AskAndroid - Android Dev Summit", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "15 May 2050", R.drawable.recycle1));
        items.add(new Items("Cyber Link increased revenue with Google", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "15 May 2050", R.drawable.recycle4));
        items.add(new Items("Android Developers", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "15 May 2050", R.drawable.recycle2));


        //Adapter int setup
        adapter = new ItemsAdapter(this, items, NightMode);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence searchSearch, int start, int before, int count) {
             adapter.getFilter().filter(searchSearch);
             search = searchSearch;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void saveThemeState(boolean nightMode) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("NightMode", nightMode);
        editor.apply();
    }

    private boolean getThemeState() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Preference", MODE_PRIVATE);
        boolean NightMode;
        NightMode = preferences.getBoolean("NightMode", false);
        return NightMode;
    }
}







