package com.koganepj.starbuckscustomorder.custom;

import com.koganepj.starbuckscustomorder.R;

import android.app.Activity;
import android.os.Bundle;

public class CustomActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        
        findViewById(R.id.TextBack).setOnClickListener(new BackTextClickListener(this));
    }
    
}