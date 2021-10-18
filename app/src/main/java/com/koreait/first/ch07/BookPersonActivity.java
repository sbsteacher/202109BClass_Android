package com.koreait.first.ch07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.koreait.first.R;

public class BookPersonActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_person);

        rvList = findViewById(R.id.rvList);

        adapter = new PersonAdapter();

        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));
        adapter.addItem(new Person("홍길동", 20));
        adapter.addItem(new Person("난다김", 22));
        adapter.addItem(new Person("블랙보리", 24));


        adapter.notifyDataSetChanged();

    }
}