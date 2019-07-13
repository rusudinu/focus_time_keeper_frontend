package com.codingshadows.focustimekeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;


public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;


    SliderAdapter(Context context)
    {
        this.context = context;
    }


    public static int getSize(){
        return slide_headigns.length;
    }

    //arrays
    private int[] slide_images = {
            R.drawable.cslogowhitewhite,
            R.drawable.cslogowhitewhite,
            R.drawable.cslogowhitewhite
    };

    private static String[] slide_headigns = {
            "Salut!",
            "Heading1",
            "Heading1"
    };

    private String[] slide_descr = {
            "Ne bucura sa te vedem citind acest tutorial! \n Daca nu gasesti ceea ce te intereseaza aici, ne poti trimite un mesaj pe Facebook (@CodingShadows) sau un email (contact@codingshadows.com)",
            "descr1",
            "descr1"
    };

    @Override
    public int getCount() {
        return slide_headigns.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView image = view.findViewById(R.id.slideImage);
        TextView slideTitle = view.findViewById(R.id.slideTitle);
        TextView slideDescription = view.findViewById(R.id.slideDescription);

        image.setImageResource(slide_images[position]);
        slideTitle.setText(slide_headigns[position]);
        slideDescription.setText(slide_descr[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
