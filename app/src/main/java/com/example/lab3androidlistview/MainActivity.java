package com.example.lab3androidlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private List<Spend> list;
    //привязка листа из ЮИ
    @BindView(R.id.list)
    ListView lv;

    List<Spend> spends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //добавление данных в список
        spends = new ArrayList<>();
        spends.add(new Spend("-200 UAH", "Products", "Bread, butter, sausages"));
        spends.add(new Spend("-100 UAH", "Internet/Phone", "Vodafone mobile phone"));
        spends.add(new Spend("-180 UAH", "Internet/Phone", "Kyivstar Home Internet"));
        spends.add(new Spend("-50 UAH", "Transport", "Taxi"));
        spends.add(new Spend("-400 UAH", "Products", "Milk, cucumbers, salt fish"));
        //Подключение ListAdapter
        ListAdapter adapter = new ListAdapter(this, spends);
        lv.setAdapter(adapter);
        //Листенер для кликов по єлементам списка
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("spent", spends.get(position).getSpent());
                intent.putExtra("category", spends.get(position).getCategory());
                intent.putExtra("comment", spends.get(position).getComment());
                startActivity(intent);
            }
        });

    }
}
