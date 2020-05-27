package com.app.databaseencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    EditText note;
    Button btnSave;
    DBHelper dbHelper;
    Context context;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        SQLiteDatabase.loadLibs(context);
        dbHelper = DBHelper.getInstance(context);
        note = findViewById(R.id.note);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = dbHelper.insertNote(note.getText().toString());
                Toast.makeText(context, "Inserted: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
