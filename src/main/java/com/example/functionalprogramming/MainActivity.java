package com.example.functionalprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.functionalprogramming.util.TestLog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.text.SimpleDateFormat;

public class MainActivity extends Activity {


//    public static final  ThreadLocal<DateTimeFormatter> formatter = ThreadLocal.withInitial(() ->new DateTimeFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
//    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hello world",Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(View -> Toast.makeText(MainActivity.this,"hello world",Toast.LENGTH_SHORT).show());
    }
}
