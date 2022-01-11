package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bb.R;
//Author:Rozerin Yıldız
public class CommentFragment extends Fragment {
    TextView txtMsg2;
    View view;

    public CommentFragment(){} // Required empty public constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_comment, container, false);

        // We get the necessary widgets
        txtMsg2 = view.findViewById(R.id.txtMsg2);


        // get the incoming message from other fragment
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");


        // Arrange the visibility by incoming message which is clicked button information
        switch (bundle.getString("key")){
            case "btn1":
                txtMsg2.setText(data);
                break;
            case "btn2":
                txtMsg2.setText(data);
                break;
            case "btn3":
                txtMsg2.setText(data);
                break;

        }

        return  view;
    }
}















