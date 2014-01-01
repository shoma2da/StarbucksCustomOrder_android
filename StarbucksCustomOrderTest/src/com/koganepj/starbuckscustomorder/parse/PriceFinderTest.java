package com.koganepj.starbuckscustomorder.parse;

import java.util.Map.Entry;

import android.test.AndroidTestCase;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Price;

public class PriceFinderTest extends AndroidTestCase {

	public void test�J�X�^�}�C�Y������l�i���擾����() {
		final PriceFinder finder = new PriceFinder(getContext());

		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(getContext());
		final NSDictionary priceDict = (NSDictionary) (rootDict
				.objectForKey("PriceDic"));
		// �J�X�^�}�C�Y�������[�v������
		for (Entry<String, NSObject> entry : priceDict.entrySet()) {

			// ����
			final Price price = finder.getPrice(entry.getKey());
			String errorMessage = String.format("%s ���݂���܂���", entry.getKey());
			assertNotNull(errorMessage, price);

			Log.d("test", String.format("%s �̒l�i�� %s �ł�.", entry.getKey(),
							price.getPrice()));
		}

	}
}
