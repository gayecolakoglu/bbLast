package com.example.bb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.bb.R;

public class ProductsFragment extends Fragment {
    View view;

    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    Button ingredients;
    Button comments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_products, container, false);
        btn1 = (ImageButton) view.findViewById(R.id.btn1);
        btn2 = (ImageButton) view.findViewById(R.id.btn2);
        btn3 = (ImageButton) view.findViewById(R.id.btn3);
        ingredients = view.findViewById(R.id.ingredients);
        comments = view.findViewById(R.id.comments);



        int clickedButtonID = view.getId();

        //Bundle ile tıklanan buttona göre ingredietns ya da commentte databaseden veri çekecez
        //çünkü butona tıkandığında aynı ingredients ve comment sayfasına gidiyoruz bu yuzden
        //tıklanan butona göre databaseden veri çekmeliyiz

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                IngredientsFragment newIngredientsFragment = new IngredientsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key1", "btn1");
                newIngredientsFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.products_frameLayout,new IngredientsFragment());
                fragmentTransaction.commit();

                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                ingredients.setVisibility(View.VISIBLE);
                comments.setVisibility(View.VISIBLE);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IngredientsFragment newIngredientsFragment = new IngredientsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key2", "btn2");
                newIngredientsFragment.setArguments(bundle);
                btn1.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                replaceFragment(new IngredientsFragment());
                ingredients.setVisibility(View.VISIBLE);
                comments.setVisibility(View.VISIBLE);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IngredientsFragment newIngredientsFragment = new IngredientsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key3", "btn3");
                newIngredientsFragment.setArguments(bundle);
                btn2.setVisibility(View.GONE);
                btn1.setVisibility(View.GONE);
                replaceFragment(new IngredientsFragment());
                ingredients.setVisibility(View.VISIBLE);
                comments.setVisibility(View.VISIBLE);

            }
        });

        ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new IngredientsFragment());
            }
        });comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new CommentFragment());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.products_frameLayout,fragment);
        fragmentTransaction.commit();

    }
}