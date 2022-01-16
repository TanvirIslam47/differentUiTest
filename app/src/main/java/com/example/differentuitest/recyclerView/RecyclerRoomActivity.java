package com.example.differentuitest.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.differentuitest.R;
import com.example.differentuitest.room.UserRoomDatabase;
import com.example.differentuitest.room.Users;

import java.util.ArrayList;
import java.util.List;

public class RecyclerRoomActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    private List<Users> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_room);

        recyclerview = findViewById(R.id.recyclerviewId);
        
        getData();

    }

    private void getData() {

        list = new ArrayList<>();
        list = UserRoomDatabase.getDatabase(getApplicationContext()).userDao().getAll();
        recyclerview.setAdapter(new RecyclerAdapter(getApplicationContext(), list));
    }
}