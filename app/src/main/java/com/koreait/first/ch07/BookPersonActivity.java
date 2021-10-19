package com.koreait.first.ch07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.koreait.first.R;
import com.koreait.first.Utils;

public class BookPersonActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private PersonAdapter adapter;
    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_person);

        rvList = findViewById(R.id.rvList);
        adapter = new PersonAdapter();
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);
    }

    public void clkReg(View v) {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        int intAge = Utils.parseStringToInt(age); //문자열 > 정수형

        if(intAge == 0) {
            Toast.makeText(this, "문제가 발생하였습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        Person p = new Person(name, intAge);
        adapter.addItem(p);
        adapter.notifyDataSetChanged();
        etName.setText("");
        etAge.setText("");
    }
}