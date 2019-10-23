package ru.imit.omsu.sweet.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.imit.omsu.sweet.R;

public class DetailsFragment extends Fragment {

    private View root;
    DetailsFragment.Listener callback;

    public interface Listener {
        public void setDat(String data,String data1);
        public void setDataLike(String data,String data1);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof AddFragment.Listener) {
            callback = (DetailsFragment.Listener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement AddFragment.Listener");
        }
    }


    public static DetailsFragment newInstance(int drawId, String text,int idComment,int idLike) {
        DetailsFragment f = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("pic", drawId);
        args.putInt("id_comment", idComment);
        args.putInt("id_like",idLike);
        args.putString("desc", text);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_details, container, false);

        String text = getArguments().getString("desc", "");;
        TextView textView = root.findViewById(R.id.des_cake);
        textView.setText(text);

        int pic = getArguments().getInt("pic",0);
        ImageView imageView = root.findViewById(R.id.cake);
        imageView.setImageDrawable(root.getContext().getDrawable(pic));
        root.findViewById(R.id.sent_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.sent_comment:
                        EditText t = root.findViewById(R.id.msg_comment);
                        String comment =  t.getText().toString();
                        int idComment = getArguments().getInt("id_comment",0);
                        callback.setDat(comment,String.valueOf(idComment));
                        Toast.makeText(root.getContext(), "Comment is adding.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        CheckBox language= (CheckBox)root.findViewById(R.id.like);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.like:
                        TextView selection = (TextView) root.findViewById(R.id.selection);
                        if (language.isChecked())
                            selection.setText(language.getText());
                        int idLike = getArguments().getInt("id_like",0);
                        callback.setDataLike(language.getText().toString(),String.valueOf(idLike));
                        Toast.makeText(root.getContext(), "You like it.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return root;
    }


}
