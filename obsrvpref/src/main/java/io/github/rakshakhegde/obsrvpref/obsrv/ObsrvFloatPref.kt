package io.github.rakshakhegde.obsrvpref.obsrv

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableFloat
import android.preference.PreferenceManager
import io.github.rakshakhegde.obsrvpref.set

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvFloatPref @JvmOverloads constructor(

		ctx: Context,
		val key: String,
		val default: Float = 0F

) : ObservableFloat(default) {

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

	override fun get(): Float = preferences.getFloat(key, default)

	override fun set(value: Float) {
		preferences[key] = value
	}
}
}