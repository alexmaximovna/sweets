package ru.imit.omsu.sweet.navigator.ui.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ru.imit.omsu.sweet.R;

public class AppInfoFragment extends Fragment {
    private InfoAppViewModel infoAppViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoAppViewModel =
                ViewModelProviders.of(this).get(InfoAppViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about_app, container, false);


        final TextView textView = root.findViewById(R.id.text_about_app);
        infoAppViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
