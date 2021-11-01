package com.example.bttrenlop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                EditText edit_Name = findViewById(R.id.name_text);
                boolean name_empty = TextUtils.isEmpty(edit_Name.getText().toString());
                EditText edit_dob = findViewById(R.id.dob_text);
                boolean dob_empty = TextUtils.isEmpty(edit_dob.getText().toString());
                EditText edit_mssv = findViewById(R.id.mssv_text);
                boolean mssv_empty = TextUtils.isEmpty(edit_mssv.getText().toString());
                EditText edit_phone = findViewById(R.id.phone_text);
                boolean phone_empty = TextUtils.isEmpty(edit_phone.getText().toString());
                EditText edit_email = findViewById(R.id.email_text);
                boolean email_empty = TextUtils.isEmpty(edit_email.getText().toString());
                if (name_empty || email_empty || dob_empty || phone_empty || mssv_empty) {
                    displayToast();
                }
            }
        });
    }
    public void displayToast() {
        Toast.makeText(this, "Du lieu nhap vao con thieu !",
                Toast.LENGTH_SHORT).show();
    }
}