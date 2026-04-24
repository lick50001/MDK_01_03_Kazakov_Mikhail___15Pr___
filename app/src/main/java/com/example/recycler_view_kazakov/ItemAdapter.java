package com.example.recycler_view_kazakov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    // 2 usages
    private LayoutInflater Inflater; // класс позволяющий из содержимого, создать View элемент

    // 3 usages
    private List<Item> Items; // список объектов

    // 3 usages
    ItemAdapter(Context context, List<Item> items) {
        this.Inflater = LayoutInflater.from(context); // инициализируем
        this.Items = items; // запоминаем объекты в переменную
    }

    // создание View
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = Inflater.inflate(R.layout.item_card, parent, false); // создаём View из свёрстанного элемента
        return new ItemAdapter.ViewHolder(view); // возвращаем
    }

    // установка значений
    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        Item Item = Items.get(position); // получаем данные из списка, для каждой View, свои данные
        holder.TvName.setText(Item.Name); // устанавливаем имя
        holder.TvModell.setText(Item.Modell); // устанавливаем модель
        holder.TvPrice.setText("₽" + String.valueOf(Item.Price)); // устанавливаем стоимость
    }

    @Override
    public int getItemCount() {
        return Items.size();
    } // метод для получения количества элементов

    // 4 usages
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // 2 usages
        final TextView TvName, TvModell, TvPrice; // текстовые поля для взаимодействия

        // 1 usage
        ViewHolder(View view) {
            super(view);
            TvName = view.findViewById(R.id.tv_name); // находим имя
            TvModell = view.findViewById(R.id.tv_model); // находим модель
            TvPrice = view.findViewById(R.id.tv_price); // находим стоимость
        }
    }
}