package com.example.homework43;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonAdapter.OnButtonClickListener {

    private RecyclerView recyclerView;
    private ButtonAdapter buttonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> buttonTextList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            buttonTextList.add("Переход на страницу " + i);
        }

        buttonAdapter = new ButtonAdapter(buttonTextList, this);
        recyclerView.setAdapter(buttonAdapter);
    }

    // Обновленный метод обратного вызова для обработки события клика на кнопке
    @Override
    public void onButtonClick(int buttonNumber) {
        // Здесь вы можете определить действие при клике на кнопке.
        // Например, осуществить переход на другую активность в зависимости от номера кнопки.
        switch (buttonNumber) {
            case 1:
                startActivity(new Intent(this, Activity1.class));
                break;
            case 2:
                startActivity(new Intent(this, Activity2.class));
                break;
            case 3:
                startActivity(new Intent(this, Activity3.class));
                break;
            case 4:
                startActivity(new Intent(this, Activity4.class));
                break;
            case 5:
                startActivity(new Intent(this, Activity5.class));
                break;

        }
    }
}
