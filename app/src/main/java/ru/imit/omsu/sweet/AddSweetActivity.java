package ru.imit.omsu.sweet;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddSweetActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sweet);
    }
    public void onClick(View view) {
        EditText textView = findViewById(R.id.dsc_sweet);
        EditText  textView1 = findViewById(R.id.name_sweet);
        switch (view.getId()){
            case R.id.add_sweet:

                Intent intent = new Intent();
                String r = textView1.getText().toString();
                intent.putExtra("dsc_sweet",textView.getText().toString());
                intent.putExtra("name_sweet", textView1.getText().toString());
                setResult(0, intent);
                Toast.makeText(AddSweetActivity.this, "Sweet is adding.", Toast.LENGTH_SHORT).show();

                finish();
        }
    }
}
