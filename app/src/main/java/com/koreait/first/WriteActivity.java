package com.koreait.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WriteActivity extends AppCompatActivity {

    private EditText etMsg;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        etMsg = findViewById(R.id.etMsg);
        btnSend = findViewById(R.id.btnSend);

        //인터페이스 객체화 가능? 불가능? > 가능(2), 불가능,
        //1. class 작성 필요
        View.OnClickListener event2 = new MyOnClickListener();
        btnSend.setOnClickListener(event2);

        //2. 변수 할당 필요
        View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View v) {}
        };
        btnSend.setOnClickListener(event);

        //3. 가장 간략하게 작성
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //콜백 메소드 (Call Back)
                Log.i("myLog", "send 클릭 됨!");
            }
        });


    }
}

class MyOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }
}