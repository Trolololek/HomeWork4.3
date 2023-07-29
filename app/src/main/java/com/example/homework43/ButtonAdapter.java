package com.example.homework43;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private List<String> buttonTextList;
    private OnButtonClickListener buttonClickListener;

    public ButtonAdapter(List<String> buttonTextList, OnButtonClickListener buttonClickListener) {
        this.buttonTextList = buttonTextList;
        this.buttonClickListener = buttonClickListener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_button, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String buttonText = buttonTextList.get(position);
        holder.button.setText(buttonText);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClick(position + 1); // Передаем номер кнопки
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return buttonTextList.size();
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {

        Button button;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }

    // Обновленный интерфейс обратного вызова для обработки события клика на кнопке
    public interface OnButtonClickListener {
        void onButtonClick(int buttonNumber); // Теперь передаем номер кнопки вместо текста кнопки
    }
}
