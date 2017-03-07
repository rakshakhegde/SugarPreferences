package io.github.rakshakhegde.obsrvpref.obsrv

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableInt
import android.preference.PreferenceManager
import io.github.rakshakhegde.obsrvpref.set

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvIntPref @JvmOverloads constructor(

		ctx: Context,
		val key: String,
		val default: Int = 0

) : ObservableInt(default) {

	protected val preferences: SharedPreferences by lazy {
		val pref = PreferenceManager.getDefaultSharedPreferences(ctx.applicationContext)
		pref.registerOnSharedPreferenceChangeListener(prefListener)
		pref
	}

	private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, _key ->
		if (_key == key) {
			notifyChange()
		}
	}

	override fun get(): Int = preferences.getInt(key, default)

	override fun set(value: Int) {
		preferences[key] = value
	}
}