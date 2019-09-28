package ru.imit.omsu.sweet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String like;
    private Animation animRotate;
    private String comment;
    private String sweetName;
    //private AppBarConfiguration mAppBarConfiguration;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Button button1 = findViewById(R.id.honey_details);
        Button button2 = findViewById(R.id.zebra_details);
        Button button3 = findViewById(R.id.peaches_details);
        ImageView imag = findViewById(R.id.honey);
        ImageView imag1 = findViewById(R.id.zebra);
        ImageView imag2 = findViewById(R.id.peaches);

        imag.setClickable(true);
        imag.setOnClickListener(this);
        imag1.setClickable(true);
        imag1.setOnClickListener(this);
        imag2.setClickable(true);
        imag2.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.invite_friends:
                Intent intent3 = new Intent(this, InviteActivity.class);
                startActivity(intent3);
                return true;
            case R.id.add_sweets:
                Intent intent4 = new Intent(this, AddSweetActivity.class);
                startActivityForResult(intent4,0);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView t = findViewById(R.id.des_honey);
        TextView t1 = findViewById(R.id.des_zebra);
        TextView t2 = findViewById(R.id.des_peaches);
        TextView t3 = findViewById(R.id.honey_like);
        TextView t4 = findViewById(R.id.honey_comment);
        TextView t5 = findViewById(R.id.zebra_like);
        TextView t6 = findViewById(R.id.zebra_comment);
        TextView t7 = findViewById(R.id.peaches_like);
        TextView t8 = findViewById(R.id.peaches_comment);
        TextView t9 = findViewById(R.id.name_example);
        ImageView im = findViewById(R.id.example);
        if(im!=null){
          outState.putString("example", String.valueOf(this.getResources().getIdentifier("example", "drawable", this.getPackageName())));
        }
        outState.putString("honey", String.valueOf(t.getCurrentTextColor()));
        outState.putString("zebra", String.valueOf(t1.getCurrentTextColor()));
        outState.putString("peaches", String.valueOf(t2.getCurrentTextColor()));
        outState.putString("name_example", String.valueOf(t9.getText()));
        outState.putString("honey_like", String.valueOf(t3.getText()));
        outState.putString("honey_comment", String.valueOf(t4.getText()));
        outState.putString("zebra_like", String.valueOf(t5.getText()));
        outState.putString("zebra_comment", String.valueOf(t6.getText()));
        outState.putString("peaches_like", String.valueOf(t7.getText()));
        outState.putString("peaches_comment", String.valueOf(t8.getText()));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
        String str = savedInstanceState.getString("honey");
        String str1 = savedInstanceState.getString("zebra");
        String str2 = savedInstanceState.getString("peaches");
        String str3 = savedInstanceState.getString("honey_like");
        String str4 = savedInstanceState.getString("honey_comment");
        String str5 = savedInstanceState.getString("zebra_like");
        String str6 = savedInstanceState.getString("zebra_comment");
        String str7 = savedInstanceState.getString("peaches_like");
        String str8 = savedInstanceState.getString("peaches_comment");
        String str9 = savedInstanceState.getString("name_example");
        String str10 = savedInstanceState.getString("example");
        if(str10 != null){
            ImageView im = findViewById(R.id.example);
            im.setImageDrawable(this.getDrawable(Integer.parseInt(str10)));
        }



        TextView  t = findViewById(R.id.des_honey);
        TextView  t1 = findViewById(R.id.des_zebra);
        TextView  t2 = findViewById(R.id.des_peaches);
        TextView t3 = findViewById(R.id.honey_like);
        TextView t4 = findViewById(R.id.honey_comment);
        TextView t5 = findViewById(R.id.zebra_like);
        TextView t6 = findViewById(R.id.zebra_comment);
        TextView t7 = findViewById(R.id.peaches_like);
        TextView t8 = findViewById(R.id.peaches_comment);
        TextView t9 = findViewById(R.id.name_example);

        t.setTextColor(Integer.parseInt(str));
        t1.setTextColor(Integer.parseInt(str1));
        t2.setTextColor(Integer.parseInt(str2));
        t3.setText(str3);
        t4.setText(str4);
        t5.setText(str5);
        t6.setText(str6);
        t7.setText(str7);
        t8.setText(str8);
        t9.setText(str9);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.honey:
                view.startAnimation(animRotate);
                animHoney();
                break;
            case R.id.zebra:
                view.startAnimation(animRotate);
                animZebra();
                break;
            case R.id.peaches:
                view.startAnimation(animRotate);
                animPeaches();
                break;
            case R.id.honey_details:
                animHoney();
                break;
            case R.id.zebra_details:
                animZebra();
                break;
            case R.id.peaches_details:
                animPeaches();
                break;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            sweetName = data.getStringExtra("name_sweet");
            like = data.getStringExtra("like");

            if(sweetName != null){
                TextView t9= findViewById(R.id.name_example);
                t9.setText(sweetName);
                ImageView imageView =findViewById(R.id.example);
                int id = this.getResources().getIdentifier("example", "drawable", this.getPackageName());
                imageView.setImageDrawable(this.getDrawable(id));
            }
            if(like!= null){
                TextView t8 = findViewById(data.getIntExtra("id_like",0));
                t8.setText(like); }

            comment = data.getStringExtra("comment");
            if(comment !=null){
            TextView t7 = findViewById(data.getIntExtra("id_comment",0));
            t7.setText(comment); }
        }
    }

    private void animHoney() {
        TextView t = findViewById(R.id.des_honey);
        t.setTextColor(Color.rgb(255, 0, 0));
        int drawId = this.getResources().getIdentifier("honey", "drawable", this.getPackageName());
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("pic", drawId);
        intent.putExtra("desc", t.getText());
        intent.putExtra("id_like", R.id.honey_like);
        intent.putExtra("id_comment", R.id.honey_comment);
        startActivityForResult(intent, 0);

    }

    private void animZebra() {
        TextView t1 = findViewById(R.id.des_zebra);
        t1.setTextColor(Color.rgb(255, 0, 0));
        int drawId1 = this.getResources().getIdentifier("zebra", "drawable", this.getPackageName());
        Intent intent1 = new Intent(this, SecondActivity.class);
        intent1.putExtra("pic", drawId1);
        intent1.putExtra("desc", t1.getText());
        intent1.putExtra("id_like", R.id.zebra_like);
        intent1.putExtra("id_comment", R.id.zebra_comment);
        startActivityForResult(intent1, 0);
    }

    private void animPeaches() {
        TextView t2 = findViewById(R.id.des_peaches);
        t2.setTextColor(Color.rgb(255, 0, 0));
        int drawId2 = this.getResources().getIdentifier("peaches", "drawable", this.getPackageName());
        Intent intent2 = new Intent(this, SecondActivity.class);
        intent2.putExtra("pic", drawId2);
        intent2.putExtra("desc", t2.getText());
        intent2.putExtra("id_like", R.id.peaches_like);
        intent2.putExtra("id_comment", R.id.peaches_comment);
        startActivityForResult(intent2, 0);
    }

//    private void hideOption(int id) {
//        MenuItem item = menu.findItem(id);
//        item.setVisible(false);
//    }
//
//    private void showOption(int id) {
//        MenuItem item = menu.findItem(id);
//        item.setVisible(true);
//    }
}
