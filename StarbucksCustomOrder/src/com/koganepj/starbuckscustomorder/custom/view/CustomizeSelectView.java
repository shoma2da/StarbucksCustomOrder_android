package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Coffee;

public class CustomizeSelectView extends LinearLayout {
    
    private LayoutInflater mInflater;
    
    public CustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.layout_custom_customize_select_view, this, true);
    }
    
    public void setCoffeeToCreateView(Coffee coffee) {
        ArrayList<ViewGroup> frameViews = getFrameViews();
        int currentFrameIndex = 0;
        
        if (coffee.base.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Base");
            view.setSelectItems(coffee.base);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }
        
        if (coffee.espresso.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Espresso");
            view.setSelectItems(coffee.espresso);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }

        if (coffee.jelly.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Jelly");
            view.setSelectItems(coffee.jelly);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }

        if (coffee.milk.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Milk");
            view.setSelectItems(coffee.milk);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }

        if (coffee.powder.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Powder");
            view.setSelectItems(coffee.powder);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }

        if (coffee.sauce.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Sauce");
            view.setSelectItems(coffee.sauce);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }

        if (coffee.syrup.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Syrup");
            view.setSelectItems(coffee.syrup);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }

        if (coffee.whippedCream.size() != 0) {
            SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
            view.setText("Whipped\nCream");
            view.setSelectItems(coffee.whippedCream);
            frameViews.get(currentFrameIndex).addView(view);
            currentFrameIndex++;
        }
    }
    
    ArrayList<ViewGroup> getFrameViews() {
        ArrayList<ViewGroup> frameViews = new ArrayList<ViewGroup>();
        
        ViewGroup topGroup = (ViewGroup)findViewById(R.id.LayoutCustomizeDetailZone);
        for (int i = 0; i < topGroup.getChildCount(); i++) {
            ViewGroup subViewGroup = (ViewGroup)topGroup.getChildAt(i);
            for (int j = 0; j < subViewGroup.getChildCount(); j++) {
                frameViews.add((ViewGroup)subViewGroup.getChildAt(j));
            }
        }
        return frameViews;
    }
    
}
