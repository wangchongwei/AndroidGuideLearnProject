package com.example.mvx.mvx.android.guide.learn.project.annotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvx.mvx.android.guide.learn.project.R;

public class SecondActivity extends AppCompatActivity {

    @InjectIntent("age")
    private int age;

    @InjectIntent("married")
    private boolean married;

    @InjectIntent("sex")
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        try {
            InjectData.inject(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        initView();
    }

    private void initView() {
        TextView textView1 = findViewById(R.id.text1);
        textView1.setText(age + "");

        TextView textView2 = findViewById(R.id.text2);
        textView2.setText(sex);

        TextView textView3 = findViewById(R.id.text3);
        textView3.setText(married + "");
    }

}