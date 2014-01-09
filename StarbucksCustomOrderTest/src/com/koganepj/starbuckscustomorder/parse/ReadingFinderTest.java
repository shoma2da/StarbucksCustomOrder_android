package com.koganepj.starbuckscustomorder.parse;

import java.util.ArrayList;
import java.util.Locale;

import android.test.AndroidTestCase;
import android.util.Log;

import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class ReadingFinderTest extends AndroidTestCase {

	public void test���i����������擾����() {
		CoffeeListParser parser = new CoffeeListParser(getContext());
		ArrayList<SimpleCoffeeModel> coffeeLists = parser.getCoffeeList();

		for (SimpleCoffeeModel model : coffeeLists) {
			CoffeeFinder finder = new CoffeeFinder(getContext(),
					model.coffeeName);
			Coffee coffee = finder.find();

			String errorMessage = String.format(Locale.getDefault(),
					"%s �̎����𐶐��ł��܂���ł����B", model.coffeeName.getCoffeeName());
			// �����𐶐��ł���������
//			assertNotNull(errorMessage, null);

			// �ꉞ�R�[�q�[�̖��O���o�͂��Ċm�F���Ă���
			Log.d("test", "The coffeeName is " + coffee.name);
		}
	}
}
