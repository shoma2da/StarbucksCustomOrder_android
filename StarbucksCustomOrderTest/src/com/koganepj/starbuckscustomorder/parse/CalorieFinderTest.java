package com.koganepj.starbuckscustomorder.parse;

import java.util.Map.Entry;

import android.test.AndroidTestCase;
import android.util.Log;

import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.koganepj.starbuckscustomorder.model.Calorie;

public class CalorieFinderTest extends AndroidTestCase {

	public void test�J�X�^�}�C�Y������J�����[���擾����() {
		final CalorieFinder finder = new CalorieFinder(getContext());

		final NSDictionary rootDict = NSDictionaryHelper
				.returnRootDictionary(getContext());
		final NSDictionary calorieDict = (NSDictionary) (rootDict
				.objectForKey("CalorieDic"));
		// �J�X�^�}�C�Y�������[�v������
		for (Entry<String, NSObject> entry : calorieDict.entrySet()) {

			// ����
			final Calorie calorie = finder.getCalorie(entry.getKey());
			String errorMessage = String.format("%s ���݂���܂���", entry.getKey());
			assertNotNull(errorMessage, calorie);

			Log.d("test", String.format("%s �̃J�����[�� %s �ł�.", entry.getKey(),
							calorie.getCalorie()));
		}

	}
}
