package ru.imit.omsu.sweet.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import ru.imit.omsu.sweet.grafics.Draw2D;

public class VectorImageFragment extends Fragment  {
    private View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Draw2D draw2D = new Draw2D(this.getContext(), 2.0f, Color.RED);
        root = draw2D;
        return root;
    }
}
