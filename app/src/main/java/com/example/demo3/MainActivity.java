package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText mValueField;
    private Button mAddBtn;
    private EditText mKeyValue;

    private DatabaseReference mRootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootRef = FirebaseDatabase.getInstance().getReference().child("Users");

        mValueField = (EditText) findViewById(R.id.valueField);
        mAddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);


        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = mValueField.getText().toString();
                String key = mKeyValue.getText().toString();

                DatabaseReference childRef = mRootRef.child(key);
                childRef.setValue(value);
            }
        });

//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference();
//
//        myRef.child("users").push().child("nolan").  setValue("member");
    }
}