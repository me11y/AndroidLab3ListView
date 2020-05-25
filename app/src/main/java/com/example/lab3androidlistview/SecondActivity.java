package com.example.lab3androidlistview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {
    //Привязка элементов ЮИ
    @BindView(R.id.spents)
    TextView spent;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.comment)
    TextView comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        //получение и вывод данных из первой активности
        spent.setText(getIntent().getStringExtra("spent"));
        category.setText(getIntent().getStringExtra("category"));
        comment.setText(getIntent().getStringExtra("comment"));
    }
}
