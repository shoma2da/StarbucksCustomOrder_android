package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;
import com.koganepj.starbuckscustomorder.model.ItemModel;

/**
 * パース処理には下記ライブラリを使用
 * https://code.google.com/p/plist/
 * Javadoc: http://dl.dropboxusercontent.com/u/2389669/plist/javadoc/index.html
 * License: MIT
 * 
 */
public class PlistProvider {
	@SuppressWarnings("unused")
	private static final String TAG = PlistProvider.class.getSimpleName();
	private static final String PLIST_NAME = "StarbucksCustomList.plist";
	
	private static Context mContext;
	private static ArrayList<ItemModel> sItemModelArray;
	
	/**
	 * Plistをパースする
	 * 
	 * @param context
	 */
	public static void parse(Context context) { 
		mContext = context;
		final NSDictionary rootDict = returnRootDictionary();
		sItemModelArray = ItemArrayParser.parse(rootDict);
	}
	
	/**
	 * 商品リストを返す
	 * 
	 * @return ArrayList<ItemModel>
	 */
	public static ArrayList<ItemModel> getItemModelList() {
		return sItemModelArray;
	}

	/**
	 * RootのDictionaryを返す
	 * 
	 * @return NSDictionary
	 */
	private static NSDictionary returnRootDictionary() {
		try {
			final AssetManager manager = mContext.getAssets();
			return (NSDictionary) PropertyListParser.parse(manager
					.open(PLIST_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}