package ru.imit.omsu.sweet.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.imit.omsu.sweet.R;

public class InviteFragment extends Fragment implements View.OnClickListener {

    private View root;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //this.setRetainInstance(true);
        root = inflater.inflate(R.layout.fragment_invite, container, false);
        Button button1 = root.findViewById(R.id.sent_msg);
        button1.setOnClickListener(this);

        return root;
    }



    @Override
    public void onClick(View view) {
        EditText textView = root.findViewById(R.id.msg);
        EditText  textView1 = root.findViewById(R.id.email);
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
                    Toast.makeText(this.getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
        }
    }



}
