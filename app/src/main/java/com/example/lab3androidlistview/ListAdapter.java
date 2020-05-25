package com.example.lab3androidlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Spend> spends; //расходы
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<Spend> spends) {
        this.spends = spends;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return spends.size();
    }

    @Override
    public String getItem(int position) {
        return spends.get(position).toString();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Преобразуем макет в дерево объектов
        View view = inflater.inflate(R.layout.list_item, parent, false);

        // Получаем доступ к виджетам дерева объектов
        TextView number = view.findViewById(R.id.number);
        TextView text = view.findViewById(R.id.text);

        // Меняем содержимое виджетов
        number.setText(spends.get(position).getSpent());
        text.setText(spends.get(position).getCategory());

        // Возвращаем модифицированное дерево объектов
        return view;
    }

    public void addItem(Spend spend){ //добавление нового элемента в список
        spends.add(spend);
    }

    public List<String> getAllItems(){
        List<String> list = new ArrayList<>();
        for(int i=0; i<spends.size(); i++){
            list.add(getItem(i));
        }
        return list;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
