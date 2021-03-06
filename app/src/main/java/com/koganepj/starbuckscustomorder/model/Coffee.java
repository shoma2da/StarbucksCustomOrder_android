package com.koganepj.starbuckscustomorder.model;

import java.util.ArrayList;

public class Coffee {
	public Type type; // 種別
	public CoffeeName name; // コーヒー名
	public Photo photo; // 画像
	public Calorie calorie; // カロリー
	public Price price; // 値段
	public ArrayList<Temperature> temperatures; // 温かさ(ホット | コールド)
	public ArrayList<Size> size; // サイズ (ショート|トール|グランデ|ベンティ)
	public ArrayList<Shot> shot; // ショット (コーヒーやサイズによってショット数が変わる)
	public ArrayList<Base> base; // ベース
	public ArrayList<Syrup> syrup; // シロップ
	public ArrayList<Sauce> sauce; //　ソース
	public ArrayList<Powder> powder; // パウダー(チョコチップ)
	public ArrayList<Jelly> jelly; // ジェリー
	public ArrayList<Milk> milk; // ミルク
	public ArrayList<WhippedCream> whippedCream; // ホイップクリーム
	public ArrayList<Espresso> espresso; // エスプレッソ
	public ArrayList<Recommend> recommend; // おすすめ
}
