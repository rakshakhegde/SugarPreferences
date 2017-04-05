package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.SharedPreferences
import io.github.rakshakhegde.sugarprefs.PreferenceHelper
import io.github.rakshakhegde.sugarprefs.prefextensions.set

/**
 * Created by rakshakhegde on 23/02/17.
 */
class ObsrvStringPref @JvmOverloads constructor(
		val key: String,
		val defaultVal: String = "",
		val preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) : ObsrvPref<String>(key, preferences) {

	override fun get(): String = preferences.getString(key, defaultVal)

	override fun set(value: String) {
		preferences[key] = value
	}
}
