package com.example.listviewtest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat"};
    private int[] images = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List集合，List集合的元素是Map
        List<Map<String,Object>> listitems = new ArrayList<>();
        for (int i=0;i<names.length;i++){
            Map<String,Object> listitem = new HashMap<>();
            listitem.put("name",names[i]);
            listitem.put("image",images[i]);
            listitems.add(listitem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitems,R.layout.activity_simple,
                new String[]{"name","image"},
                new int[]{R.id.text1,R.id.image1});
        ListView list = findViewById(R.id.mylist);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast=Toast.makeText(MainActivity.this,names[position]+"被选中",Toast.LENGTH_SHORT);
                //设置toast位置
                toast.setGravity(Gravity.CENTER, 0, 200);
                toast.show();
            }
        });
        // 为ListView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast toast=Toast.makeText(MainActivity.this,names[position]+"被选中",Toast.LENGTH_SHORT);
                //设置toast位置
                toast.setGravity(Gravity.CENTER, 0, 200);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }
}
