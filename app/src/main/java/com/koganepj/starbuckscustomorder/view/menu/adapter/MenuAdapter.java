package com.koganepj.starbuckscustomorder.view.menu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.view.menu.adapter.modelwrapper.MenuCellModel;

public class MenuAdapter extends ArrayAdapter<MenuCellModel> {
    
    private LayoutInflater mInflater;
    private MenuMode mCurrentMenuMode;
    private CoffeeImageLoader mCoffeeImageLoader;

    public MenuAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
        mCoffeeImageLoader = new CoffeeImageLoader(context.getResources());
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuCellModel cellModel = getItem(position);
        
        if (cellModel.isType()) {
            TextView sectionView = (TextView)mInflater.inflate(R.layout.layout_menu_section_type, null);
            sectionView.setText(cellModel.toType().getType());
            return sectionView;
        }
        
        View view = convertView;
        if (convertView == null || convertView.getClass() == TextView.class) {
            view = createCellView();
            
            //各Viewをキャッシュしておくことで高速化
            MenuCellViewHolder holder = new MenuCellViewHolder();
            holder.imageView = (ImageView)view.findViewById(R.id.ImageCoffeePicture);
            holder.textView = (TextView)view.findViewById(R.id.TextCoffeeName);
            view.setTag(holder);
        }
        
        SimpleCoffeeModel coffeeModel = cellModel.toSimpleCoffeeModel();
        
        //キャッシュを取り出して表示設定する
        MenuCellViewHolder holder = (MenuCellViewHolder)view.getTag();
        Bitmap bitmap = mCoffeeImageLoader.loadImage(coffeeModel.photo.getPhoto(), mCurrentMenuMode);
        holder.imageView.setImageBitmap(bitmap);
        holder.textView.setText(coffeeModel.coffeeName.getCoffeeName());
        
        return view;
    }
    
    private View createCellView() {
        if (mCurrentMenuMode == MenuMode.SIMPLE) {
            return mInflater.inflate(R.layout.layout_menu_list_simple_cell, null);
        } else {
            return mInflater.inflate(R.layout.layout_menu_list_visual_cell, null);
        }
    }
    
    public void setModeTo(MenuMode menuMode) {
        mCurrentMenuMode = menuMode;
    }
    
    @Override
    public boolean isEnabled(int position) {
        return getItem(position).isType() == false;//タイプ「ではない」場合がタップ可能
    }

}
