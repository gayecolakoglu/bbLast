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
//Author:Rozerin Yıldız
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

        // We get the necessary widgets
        btn1 = (ImageButton) view.findViewById(R.id.btn1);
        btn2 = (ImageButton) view.findViewById(R.id.btn2);
        btn3 = (ImageButton) view.findViewById(R.id.btn3);
        ingredients = view.findViewById(R.id.ingredients);
        comments = view.findViewById(R.id.comments);



        // Send message about clicked button to the Ingredients and Comment Fragments with Bundle
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key","btn1".toString());

                //Bundle bundle2 = new Bundle();
                //bundle2.putString("key1","btn1".toString());

                IngredientsFragment newFragment = new IngredientsFragment();
                newFragment.setArguments(bundle);

                // set opening fragments to the IngredientsFragment
                getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment).commit();

                CommentFragment newFragment2 = new CommentFragment();
                newFragment2.setArguments(bundle);

                // change fragment with bundle message if button clicked
                ingredients.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment).commit();
                    }
                });

                // change fragment with bundle message if button clicked
                comments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment2).commit();
                    }
                });

                // Make VISIBLE and GONE necessary buttons
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                //replaceFragment(new IngredientsFragment());
                ingredients.setVisibility(View.VISIBLE);
                comments.setVisibility(View.VISIBLE);

            }
        });

        // Send message about clicked button to the Ingredients and Comment Fragments with Bundle
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key","btn2".toString());

                //Bundle bundle2 = new Bundle();
                //bundle2.putString("key1","btn1".toString());

                IngredientsFragment newFragment = new IngredientsFragment();
                newFragment.setArguments(bundle);

                // set opening fragments to the IngredientsFragment
                getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment).commit();

                CommentFragment newFragment2 = new CommentFragment();
                newFragment2.setArguments(bundle);

                // change fragment with bundle message if button clicked
                ingredients.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment).commit();
                    }
                });

                // change fragment with bundle message if button clicked
                comments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment2).commit();
                    }
                });

                // Make VISIBLE and GONE necessary buttons
                btn1.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                //replaceFragment(new IngredientsFragment());
                ingredients.setVisibility(View.VISIBLE);
                comments.setVisibility(View.VISIBLE);

            }
        });

        // Send message about clicked button to the Ingredients and Comment Fragments with Bundle
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key","btn3".toString());

                //Bundle bundle2 = new Bundle();
                //bundle2.putString("key1","btn1".toString());

                IngredientsFragment newFragment = new IngredientsFragment();
                newFragment.setArguments(bundle);

                // set opening fragments to the IngredientsFragment
                getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment).commit();

                CommentFragment newFragment2 = new CommentFragment();
                newFragment2.setArguments(bundle);

                // change fragment with bundle message if button clicked
                ingredients.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment).commit();
                    }
                });

                // change fragment with bundle message if button clicked
                comments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.products_frameLayout,newFragment2).commit();
                    }
                });

                // Make VISIBLE and GONE necessary buttons
                btn2.setVisibility(View.GONE);
                btn1.setVisibility(View.GONE);
                //replaceFragment(new IngredientsFragment());
                ingredients.setVisibility(View.VISIBLE);
                comments.setVisibility(View.VISIBLE);

            }
        });




        return view;
    }

}