package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cancel(View source){
        Toast toast=Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT   );
        //设置toast位置
        toast.setGravity(Gravity.CENTER, 0, 200);
        toast.show();
    }

    public void sign_in(View source){
        Toast toast=Toast.makeText(MainActivity.this,"Signin",Toast.LENGTH_SHORT   );
        //设置toast位置
        toast.setGravity(Gravity.CENTER, 0, 200);
        toast.show();
    }

    public void alertDialog(View source)
    {
        // 加载\res\layout\login.xml界面布局文件
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        new AlertDialog.Builder(this)
                // 设置对话框显示的View对象
                .setView(loginForm)
                // 创建并显示对话框
                .create().show();
    }
}