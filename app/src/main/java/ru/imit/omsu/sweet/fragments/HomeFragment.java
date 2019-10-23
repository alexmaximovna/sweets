package ru.imit.omsu.sweet.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ru.imit.omsu.sweet.R;



public class HomeFragment extends Fragment implements View.OnClickListener{

    private View root;
    private Animation animRotate;
    private FragmentManager fTrans;
    private FragmentTransaction fragmentTransaction;
    private DetailsFragment dt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        fTrans = this.getActivity().getSupportFragmentManager();
        dt = new DetailsFragment();
        fragmentTransaction = fTrans.beginTransaction();


    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.setRetainInstance(true);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        Button button1 = root.findViewById(R.id.honey_details);
        Button button2 = root.findViewById(R.id.zebra_details);
        Button button3 = root.findViewById(R.id.peaches_details);
        ImageView imag = root.findViewById(R.id.honey);
        ImageView imag1 = root.findViewById(R.id.zebra);
        ImageView imag2 = root.findViewById(R.id.peaches);

        imag.setClickable(true);
        imag.setOnClickListener(this);
        imag1.setClickable(true);
        imag1.setOnClickListener(this);
        imag2.setClickable(true);
        imag2.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        animRotate = AnimationUtils.loadAnimation(root.getContext(), R.anim.rotate);
        return root;
    }

    public void setAttributes(String link, String link1){
        TextView t  = getActivity().findViewById(R.id.name_example);
        t.setText(link);
        t.setVisibility(View.VISIBLE);
        TextView t1 = root.findViewById(R.id.dsc_example);
        t1.setText(link1);
        t1.setVisibility(View.VISIBLE);
        ImageView imageView = root.findViewById(R.id.example);
        imageView.setVisibility(View.VISIBLE);

    }

    @Override
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


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView t = root.findViewById(R.id.des_honey);
        TextView t1 = root.findViewById(R.id.des_zebra);
        TextView t2 = root.findViewById(R.id.des_peaches);
        TextView t3 = root.findViewById(R.id.honey_like);
        TextView t4 = root.findViewById(R.id.honey_comment);
        TextView t5 = root.findViewById(R.id.zebra_like);
        TextView t6 = root.findViewById(R.id.zebra_comment);
        TextView t7 = root.findViewById(R.id.peaches_like);
        TextView t8 = root.findViewById(R.id.peaches_comment);
        TextView t9 = root.findViewById(R.id.name_example);
        ImageView im = root.findViewById(R.id.example);
        if (im != null) {
            outState.putString("example", String.valueOf(this.getResources().getIdentifier("example", "drawable", root.getContext().getPackageName())));
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


    public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    if (savedInstanceState == null)
        return;
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
    if (str10 != null) {
        ImageView im = root.findViewById(R.id.example);
        im.setImageDrawable(root.getContext().getDrawable(Integer.parseInt(str10)));
    }


    TextView t = root.findViewById(R.id.des_honey);
    TextView t1 = root.findViewById(R.id.des_zebra);
    TextView t2 = root.findViewById(R.id.des_peaches);
    TextView t3 = root.findViewById(R.id.honey_like);
    TextView t4 = root.findViewById(R.id.honey_comment);
    TextView t5 = root.findViewById(R.id.zebra_like);
    TextView t6 = root.findViewById(R.id.zebra_comment);
    TextView t7 = root.findViewById(R.id.peaches_like);
    TextView t8 = root.findViewById(R.id.peaches_comment);
    TextView t9 = root.findViewById(R.id.name_example);

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

    private void animHoney() {
        TextView t = root.findViewById(R.id.des_honey);
        t.setTextColor(Color.rgb(255, 0, 0));
        int drawId = root.getContext().getResources().getIdentifier("honey", "drawable", root.getContext().getPackageName());
        dt =  DetailsFragment.newInstance(drawId,t.getText().toString(),R.id.honey_comment,R.id.honey_like);
        fragmentTransaction = fTrans.beginTransaction();
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.frame_container, dt);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void animZebra() {
        TextView t1 = root.findViewById(R.id.des_zebra);
        t1.setTextColor(Color.rgb(255, 0, 0));
        int drawId1 = this.getResources().getIdentifier("zebra", "drawable", root.getContext().getPackageName());
        dt =  DetailsFragment.newInstance(drawId1,t1.getText().toString(),R.id.zebra_comment,R.id.zebra_like);
        fragmentTransaction = fTrans.beginTransaction();
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.frame_container, dt);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void animPeaches() {
        TextView t2 = root.findViewById(R.id.des_peaches);
        t2.setTextColor(Color.rgb(255, 0, 0));
        int drawId2 = this.getResources().getIdentifier("peaches", "drawable", root.getContext().getPackageName());
        dt =  DetailsFragment.newInstance(drawId2,t2.getText().toString(),R.id.peaches_comment,R.id.peaches_like);
        fragmentTransaction = fTrans.beginTransaction();
        fragmentTransaction.hide(this);
        fragmentTransaction.add(R.id.frame_container, dt);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void setAtt(String comment, String idComment) {
        TextView t7 = root.findViewById(Integer.valueOf(idComment));
        t7.setText(comment);
        fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(dt);
        fragmentTransaction.commit();

    }
    public void setAttLike(String like, String idLike) {
        TextView t8 = root.findViewById(Integer.valueOf(idLike));
        t8.setText(like);
        fragmentTransaction = this.getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(dt);
        fragmentTransaction.commit();

    }
}