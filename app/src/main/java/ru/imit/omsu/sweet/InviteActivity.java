package ru.imit.omsu.sweet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InviteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);


    }

    public void onClick(View view) {
        EditText textView = findViewById(R.id.msg);
        EditText  textView1 = findViewById(R.id.email);
        switch (view.getId()){
            case R.id.sent_msg:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{String.valueOf(textView1.getText())});
                i.putExtra(Intent.EXTRA_SUBJECT, "Install my App");
                i.putExtra(Intent.EXTRA_TEXT   , textView.getText());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(InviteActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
