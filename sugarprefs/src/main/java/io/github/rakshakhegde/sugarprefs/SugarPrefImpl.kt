package io.github.rakshakhegde.sugarprefs

import android.content.SharedPreferences
import android.databinding.BaseObservable

/**
 * Created by rakshakhegde on 07/03/17.
 */

/**
 * TODO If context is passed use it's preferences
 */
class SugarPrefImpl(
		observable: BaseObservable,
		key: String,
		preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) {

	private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener { _, _key ->
		if (_key == key) {
			observable.notifyChange()
		}
	}

	init {
		preferences.registerOnSharedPreferenceChangeListener(prefListener)
	}
}
