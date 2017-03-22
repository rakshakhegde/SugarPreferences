package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.SharedPreferences
import android.databinding.ObservableFloat
import io.github.rakshakhegde.sugarprefs.PreferenceHelper
import io.github.rakshakhegde.sugarprefs.SugarPrefImpl
import io.github.rakshakhegde.sugarprefs.prefextensions.set

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvFloatPref @JvmOverloads constructor(
		val key: String,
		val defaultVal: Float = 0F,
		val preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) : ObservableFloat(defaultVal) {

	private val sugarPref = SugarPrefImpl(this, key, preferences)

	override fun get(): Float = preferences.getFloat(key, defaultVal)

	override fun set(value: Float) {
		preferences[key] = value
	}
}
