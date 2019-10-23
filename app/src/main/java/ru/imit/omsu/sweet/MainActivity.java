package ru.imit.omsu.sweet;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import ru.imit.omsu.sweet.fragments.AddFragment;
import ru.imit.omsu.sweet.fragments.DetailsFragment;
import ru.imit.omsu.sweet.fragments.InviteFragment;
import ru.imit.omsu.sweet.fragments.VectorImageFragment;
import ru.imit.omsu.sweet.fragments.HomeFragment;


public class MainActivity extends AppCompatActivity implements
        AddFragment.Listener, DetailsFragment.Listener {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private InviteFragment inviteFragment;
    private AddFragment addFragment;
    private VectorImageFragment vectorImageFragment;
    private HomeFragment homeFragment;
    private FragmentManager fTrans;
    private FragmentTransaction fragmentTransaction;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inviteFragment = new InviteFragment();
        addFragment = new AddFragment();
        vectorImageFragment = new VectorImageFragment();
        homeFragment = new HomeFragment();
        fTrans = this.getSupportFragmentManager();
        fragmentTransaction = fTrans.beginTransaction();
        setContentView(R.layout.activity_main);
        fragmentTransaction.add(R.id.frame_container, homeFragment);
        fragmentTransaction.commit();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dl = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                fragmentTransaction = fTrans.beginTransaction();
                switch(id)
                {
                    case R.id.nav_home:
                        fragmentTransaction.replace(R.id.frame_container,homeFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        Toast.makeText(MainActivity.this, "My HomeScreen",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_app:
                        Toast.makeText(MainActivity.this, "This app is created for fans of sweet"+
                                "You can show,make publications,share with friends your emotions about something sweet," +
                                "stay comments,like pictures  and etc ..",Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.nav_exit:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Are you sure you want to exit?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        MainActivity.this.finish();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        return true;

                    default:
                        return true;
                }

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        fragmentTransaction = fTrans.beginTransaction();
        switch (id) {
            case R.id.invite_friends:
                fragmentTransaction.replace(R.id.frame_container, inviteFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;
            case R.id.add_sweets:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.add(R.id.frame_container, addFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;

            case R.id.image:
                fragmentTransaction.replace(R.id.frame_container, vectorImageFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void setData(String data, String data1) {
        homeFragment.setAttributes(data,data1);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.show(homeFragment);
                transaction.hide(addFragment);
                transaction.addToBackStack(null);
                transaction.commit();
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void setDat(String data, String data1) {
        homeFragment.setAtt(data,data1);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void setDataLike(String data, String data1) {
        homeFragment.setAttLike(data,data1);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}



