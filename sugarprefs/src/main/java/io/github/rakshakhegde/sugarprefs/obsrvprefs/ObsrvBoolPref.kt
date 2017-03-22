package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.SharedPreferences
import android.databinding.ObservableBoolean
import io.github.rakshakhegde.sugarprefs.PreferenceHelper
import io.github.rakshakhegde.sugarprefs.SugarPrefImpl
import io.github.rakshakhegde.sugarprefs.prefextensions.set

/**
 * Created by rakshakhegde on 23/02/17.
 */
class ObsrvBoolPref @JvmOverloads constructor(
		val key: String,
		val defaultVal: Boolean = false,
		val preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) : ObservableBoolean(defaultVal) {

	private val sugarPref = SugarPrefImpl(this, key, preferences)

	override fun get(): Boolean = preferences.getBoolean(key, defaultVal)

	override fun set(value: Boolean) {
		preferences[key] = value
	}
}
