package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableFloat
import android.preference.PreferenceManager
import io.github.rakshakhegde.sugarprefs.prefextensions.set

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvFloatPref @JvmOverloads constructor(

		ctx: Context,
		val key: String,
		val defaultVal: Float = 0F

) : ObservableFloat(defaultVal) {

	protected val preferences: SharedPreferences by lazy {
		val pref = PreferenceManager.getDefaultSharedPreferences(ctx.applicationContext)
		pref.registerOnSharedPreferenceChangeListener(prefListener)
		pref
	}

	private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener { _, _key ->
		if (_key == key) {
			notifyChange()
		}
	}

	override fun get(): Float = preferences.getFloat(key, defaultVal)

	override fun set(value: Float) {
		preferences[key] = value
	}
}
