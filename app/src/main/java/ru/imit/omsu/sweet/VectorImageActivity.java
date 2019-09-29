package ru.imit.omsu.sweet;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class VectorImageActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Draw2D draw2D = new Draw2D(this, 2.0f, Color.RED);
        setContentView(draw2D);
    }
}
