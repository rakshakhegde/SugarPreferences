package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.SharedPreferences
import android.databinding.ObservableInt
import io.github.rakshakhegde.sugarprefs.PreferenceHelper
import io.github.rakshakhegde.sugarprefs.SugarPrefImpl
import io.github.rakshakhegde.sugarprefs.prefextensions.set

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvIntPref @JvmOverloads constructor(
		val key: String,
		val defaultVal: Int = 0,
		val preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) : ObservableInt(defaultVal) {

	private val sugarPref = SugarPrefImpl(this, key, preferences)

	override fun get(): Int = preferences.getInt(key, defaultVal)

	override fun set(value: Int) {
		preferences[key] = value
	}
}
