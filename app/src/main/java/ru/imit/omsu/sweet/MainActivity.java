package ru.imit.omsu.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.honey_details);
        Button button2 = findViewById(R.id.zebra_details);
        Button button3 = findViewById(R.id.peaches_details);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView  t = findViewById(R.id.des_honey);
        TextView  t1 = findViewById(R.id.des_zebra);
        TextView  t2 = findViewById(R.id.des_peaches);
        outState.putString("honey", String.valueOf(t.getCurrentTextColor()));
        outState.putString("zebra", String.valueOf(t1.getCurrentTextColor()));
        outState.putString("peaches", String.valueOf(t2.getCurrentTextColor()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
        String str = savedInstanceState.getString("honey");
        String str1 = savedInstanceState.getString("zebra");
        String str2 = savedInstanceState.getString("peaches");
        TextView  t = findViewById(R.id.des_honey);
        TextView  t1 = findViewById(R.id.des_zebra);
        TextView  t2 = findViewById(R.id.des_peaches);
        t.setTextColor(Integer.parseInt(str));
        t1.setTextColor(Integer.parseInt(str1));
        t2.setTextColor(Integer.parseInt(str2));

    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.honey_details:
                TextView  t = findViewById(R.id.des_honey);
                t.setTextColor(Color.rgb(255,0,0));
                int drawId = this.getResources().getIdentifier("honey","drawable",this.getPackageName());
                Intent intent = new Intent(this,SecondActivity.class);
                intent.putExtra("pic", drawId);
                intent.putExtra("desc",t.getText());
                startActivity(intent);
                break;
            case R.id.zebra_details:
                TextView  t1 = findViewById(R.id.des_zebra);
                t1.setTextColor(Color.rgb(255,0,0));
                int drawId1 = this.getResources().getIdentifier("zebra","drawable",this.getPackageName());
                Intent intent1 = new Intent(this,SecondActivity.class);
                intent1.putExtra("pic", drawId1);
                intent1.putExtra("desc",t1.getText());
                startActivity(intent1);
                break;
            case R.id.peaches_details:
                TextView  t2 = findViewById(R.id.des_peaches);
                t2.setTextColor(Color.rgb(255,0,0));
                int drawId2 = this.getResources().getIdentifier("peaches","drawable",this.getPackageName());
                Intent intent2 = new Intent(this,SecondActivity.class);
                intent2.putExtra("pic", drawId2);
                intent2.putExtra("desc",t2.getText());
                startActivity(intent2);
                break;


        }
    }
}
