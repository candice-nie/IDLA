package com.example.idla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.Lesson03.Lesson03Activity;
import com.example.idla.Lesson04.Lesson04Activity;
import com.example.idla.Lesson05.Lesson05Activity;
import com.example.idla.Lesson06_10.Lesson06Activity;
import com.example.idla.Lesson06_10.Lesson07Activity;
import com.example.idla.Lesson06_10.Lesson08Activity;
import com.example.idla.Lesson06_10.Lesson09Activity;
import com.example.idla.Lesson06_10.Lesson10Activity;
import com.example.idla.Lesson11.Lesson11Activity;
import com.example.idla.Lesson12.Lesson12Activity;
import com.example.idla.Lesson13.Lesson13Activity;
import com.example.idla.Lesson14.Lesson14Activity;
import com.example.idla.Lesson15.Lesson15Activity;
import com.example.idla.Lesson16.Lesson16Activity;
import com.example.idla.Lesson18.Register.ui.login.Lesson18RegisterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView; //畫面
    private List<String> titles; //標題
    private List<Class> classes; //型別
    private List<Object> items; //標題+型別
    private ArrayAdapter arrayAdapter; //適配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MarkFly","Hello World");

        listView = findViewById(R.id.main_listView); //取得畫面

        setupData(); //產生資料

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, titles); //使用樣式跟資料產生適配器
        listView.setAdapter(arrayAdapter); //餵給listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //監聽事件(大括號裡除了實作方法, 不能寫別的東西)

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { //變數名稱不明

            Intent intent = new Intent(MainActivity.this, classes.get(i));//不能只寫.this (因為是在閉包裡面吧)
            intent.putExtra("title",titles.get(i));
            startActivity(intent);

            }
        });

    }

    private void setupData() {
        titles = new ArrayList<>();
        titles.add("Lesson 03 - Activity");
        titles.add("Lesson 04 - Layout");
        titles.add("Lesson 05 - ConstraintLayout");
        titles.add("Lesson 06 - TextView/EditText/Button/Dialog");
        titles.add("Lesson 07 - ImagePicker");
        titles.add("Lesson 08 - Spinner/DatePickerDialog");
        titles.add("Lesson 09 - 各種按鈕");
        titles.add("Lesson 10 - SeekBar/ProgressBar");
        titles.add("Lesson 11 - RecycleView");
        titles.add("Lesson 12 - BottomNavigation");
        titles.add("Lesson 13 - call API");
        titles.add("Lesson 14 - JSON to Model");
        titles.add("Lesson 15 - Activity Gallery");
        titles.add("Lesson 16 - 指紋辨識");
        titles.add("Lesson 18 - 本地儲存");

        classes = new ArrayList<>();
        classes.add(Lesson03Activity.class);
        classes.add(Lesson04Activity.class);
        classes.add(Lesson05Activity.class);
        classes.add(Lesson06Activity.class);
        classes.add(Lesson07Activity.class);
        classes.add(Lesson08Activity.class);
        classes.add(Lesson09Activity.class);
        classes.add(Lesson10Activity.class);
        classes.add(Lesson11Activity.class);
        classes.add(Lesson12Activity.class);
        classes.add(Lesson13Activity.class);
        classes.add(Lesson14Activity.class);
        classes.add(Lesson15Activity.class);
        classes.add(Lesson16Activity.class);
        classes.add(Lesson18RegisterActivity.class);

        items = new ArrayList<>();//等學會Adapter再用
        for(String str: titles)
        {
            int index = titles.indexOf(str);
            HashMap hashMap = new HashMap<String,Object>();
            hashMap.put("cls",classes.get(index));
            hashMap.put("title",titles.get(index));
            items.add(hashMap);
        }
    }
}
