package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.SharedPreferences
import android.databinding.ObservableLong
import io.github.rakshakhegde.sugarprefs.PreferenceHelper
import io.github.rakshakhegde.sugarprefs.SugarPrefImpl
import io.github.rakshakhegde.sugarprefs.prefextensions.set

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvLongPref @JvmOverloads constructor(
		val key: String,
		val defaultVal: Long = 0,
		val preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) : ObservableLong(defaultVal) {

	private val sugarPref = SugarPrefImpl(this, key, preferences)

	override fun get(): Long = preferences.getLong(key, defaultVal)

	override fun set(value: Long) {
		preferences[key] = value
	}
}