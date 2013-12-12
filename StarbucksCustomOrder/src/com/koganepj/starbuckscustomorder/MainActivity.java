package com.koganepj.starbuckscustomorder;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

import com.koganepj.starbuckscustomorder.tablistener.LikeTabListener;
import com.koganepj.starbuckscustomorder.tablistener.MenuTabListener;
import com.koganepj.starbuckscustomorder.tablistener.RankingTabListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //タブの初期設定-------------
        ActionBar actionBar =  getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        Tab likeTab = actionBar.newTab().setText(R.string.tab_like);
        Tab menuTab = actionBar.newTab().setText(R.string.tab_menu);
        Tab rankTab = actionBar.newTab().setText(R.string.tab_ranking);
        
        FragmentManager fragmentManager= getFragmentManager();
        int rootViewId = R.id.LayoutContainer;
        
        likeTab.setTabListener(new LikeTabListener(actionBar, fragmentManager, rootViewId));
        menuTab.setTabListener(new MenuTabListener(actionBar, fragmentManager, rootViewId));
        rankTab.setTabListener(new RankingTabListener(actionBar, fragmentManager, rootViewId));
        
        actionBar.addTab(likeTab);
        actionBar.addTab(menuTab);
        actionBar.addTab(rankTab);
        //--------------------------
    }
}