package com.example.asuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asuno.Classes.ApiQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TubeControl extends AppCompatActivity {
    String gObjectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tube_control);

        Intent intent = getIntent();
        int id = intent.getIntExtra("valuse", 0);

        String name = intent.getStringExtra("name");
        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(name);

        String value = intent.getStringExtra("value");
        TextView tvValue = findViewById(R.id.tvValue);
        tvValue.setText(value);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        String date = simpleDateFormat.format(new Date());
       // String date = intent.getStringExtra("date");
        TextView tvDate = findViewById(R.id.tvDate);
        tvDate.setText(date);

        gObjectId = intent.getStringExtra("objectId");
        Button btnPoll = findViewById(R.id.btnPoll);

        String[] data = {"one", "two", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
    });
    }
    public void onClickBtnPoll(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiQuery.Instance().Poll(gObjectId, "", "Current", TubeControl.this);
            }
        }).start();
    }
    public void onClickBtnOn(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiQuery.Instance().Poll(gObjectId, "", "Current", TubeControl.this);
            }
        }).start();
    }
    public void onClickBtnOff(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiQuery.Instance().Poll(gObjectId, "", "Current", TubeControl.this);
            }
        }).start();
    }


}
