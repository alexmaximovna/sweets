package ru.imit.omsu.sweet;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;


public class SecondActivity extends Activity implements View.OnClickListener {



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

    public void onClick(View view) {
        if (view.getId() == R.id.sent_comment) {
            EditText t = findViewById(R.id.msg_comment);
            String comment =  t.getText().toString();
            int id = getIntent().getIntExtra("id_comment",0);
            Intent intent = new Intent();
            intent.putExtra("id_comment",id);
            intent.putExtra("comment", comment);
            setResult(0, intent);
            Toast.makeText(SecondActivity.this, "Comment is adding.", Toast.LENGTH_SHORT).show();

            finish();
        }
    }
    public void onCheckboxClicked(View view) {
        CheckBox language = (CheckBox) view;
        TextView selection = (TextView) findViewById(R.id.selection);
        if(language.isChecked())
            selection.setText(language.getText());
        int id = getIntent().getIntExtra("id_like",0);
        Intent intent = new Intent();
        intent.putExtra("id_like",id);
        intent.putExtra("like",language.getText());
        setResult(0,intent);
        Toast.makeText(SecondActivity.this, "You like it.", Toast.LENGTH_SHORT).show();
        finish();
    }

}
