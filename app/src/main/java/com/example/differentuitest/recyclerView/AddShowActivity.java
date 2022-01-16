package com.example.differentuitest.recyclerView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.differentuitest.R;
import com.example.differentuitest.room.UserRoomDatabase;
import com.example.differentuitest.room.Users;

public class AddShowActivity extends AppCompatActivity {

    EditText firstName, lastName;
    Button save, getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);

        firstName = findViewById(R.id.firstNameId);
        lastName = findViewById(R.id.lastNameId);
        save = findViewById(R.id.btn_save);
        getData = findViewById(R.id.btn_getData);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerRoomActivity.class));
            }
        });
    }

    private void saveData() {

        String f_name_txt = firstName.getText().toString().trim();
        String l_name_txt = lastName.getText().toString().trim();

        Users model = new Users();
        model.setFirstName(f_name_txt);
        model.setLastName(l_name_txt);
        UserRoomDatabase.getDatabase(getApplicationContext()).userDao().insertAll(model);

        firstName.setText("");
        lastName.setText("");
        Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();


    }

}