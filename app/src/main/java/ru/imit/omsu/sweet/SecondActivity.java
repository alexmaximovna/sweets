package ru.imit.omsu.sweet;


import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;


public class SecondActivity extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String text = getIntent().getStringExtra("desc");
        TextView textView = findViewById(R.id.des_cake);
        textView.setText(text);
        int pic = getIntent().getIntExtra("pic",0);
        ImageView imageView = findViewById(R.id.cake);
        imageView.setImageDrawable(this.getDrawable(pic));

    }

}
