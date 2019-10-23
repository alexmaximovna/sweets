package ru.imit.omsu.sweet.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.imit.omsu.sweet.R;

public class AddFragment extends Fragment {

    private View root;

    Listener callback;

    public interface Listener {
        public void setData(String data,String data1);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof AddFragment.Listener) {
            callback = (AddFragment.Listener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement AddFragment.Listener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_add_sweet, container, false);
        EditText textView = root.findViewById(R.id.dsc_sweet);
        EditText  textView1 = root.findViewById(R.id.name_sweet);
        root.findViewById(R.id.add_sweet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.add_sweet:
                        callback.setData(textView1.getText().toString(),textView.getText().toString());
                        Toast.makeText(root.getContext(), "Sweet is adding.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return root;
    }





//
//    public void setOnHeadlineSelectedListener(Listener callback) {
//        this.callback = callback;
//    }




//    private AddFragment.OnItemSelectedListener mListener;
//
//
//    public interface OnItemSelectedListener {
//        public void onItemSelected(String link,String link1);
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        if (context instanceof AddFragment.OnItemSelectedListener) {
//            mListener = (AddFragment.OnItemSelectedListener) context;
//        } else {
//            throw new ClassCastException(context.toString()
//                    + " must implement MyListFragment.OnItemSelectedListener");
//        }
//    }



//    @Override
//    public void onClick(View view) {
//        EditText textView = root.findViewById(R.id.dsc_sweet);
//        EditText  textView1 = root.findViewById(R.id.name_sweet);
//        root.findViewById(R.id.add_sweet).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (view.getId()){
//                    case R.id.add_sweet:
//                        Intent intent = new Intent();
//                        String r = textView1.getText().toString();
//                        intent.putExtra("dsc_sweet",textView.getText().toString());
//                        intent.putExtra("name_sweet", textView1.getText().toString());
//                        getActivity().setResult(0, intent);
//                        Toast.makeText(root.getContext(), "Sweet is adding.", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//    }


}
