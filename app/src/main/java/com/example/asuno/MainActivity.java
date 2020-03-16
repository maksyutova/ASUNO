package com.example.asuno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asuno.Classes.ApiQuery;
import com.example.asuno.Classes.GetSessionId.SessionJson;
import com.example.asuno.Classes.RowCache.RowCache;
import com.example.asuno.Classes.RowCache.RowFromRowCache;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private TextView textViewResult;
    Gson gson = new Gson();
    String gSessionId = "";
    RowFromRowCache[] rows1;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);
        listView = findViewById(R.id.tubes);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiQuery.Instance().GetSession();
                RowFromRowCache[] rows =ApiQuery.Instance().RowCache();
                rows1 = rows;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                ArrayList<String> listTube = new ArrayList<>();
                final String pname = "";
                for (int i = 0; i < rows.length; i++) {
                    //if(!rows[i].getPname().equals("АСКУЭ")) continue;
                    String date = (rows[i].getDateDt() == null) ? "" : simpleDateFormat.format(rows[i].getDateDt());
                    String addTmp = rows[i].getName() + " : "+ rows[i].getValue()+ " кВт*ч "  + rows[i].getDate();
                    listTube.add(addTmp);
                   // name += rows[i].getName() + "\n";
                }

                final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        listTube
                );
                final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, TubeControl.class);
                        intent.putExtra("value", rows1[position].getValue());
                        intent.putExtra("name", rows1[position].getName());
                        intent.putExtra("date", rows1[position].getDate());
                        intent.putExtra("objectId", rows1[position].getId());

                        startActivity(intent);
                    }
                };
                listView.post(new Runnable() {
                        @Override
                        public void run() {
                           // String allValues = name +"\n"+ value;
                            listView.setAdapter(listAdapter);
                            listView.setOnItemClickListener(onItemClickListener);
                        }

                });
            }
        }).start();

    }

}
