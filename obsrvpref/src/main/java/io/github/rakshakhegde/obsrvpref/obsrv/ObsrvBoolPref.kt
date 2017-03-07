package io.github.rakshakhegde.obsrvpref.obsrv

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableBoolean
import android.preference.PreferenceManager
import io.github.rakshakhegde.obsrvpref.set

/**
 * Created by rakshakhegde on 23/02/17.
 */
class ObsrvBoolPref @JvmOverloads constructor(

		ctx: Context,
		val key: String,
		val default: Boolean = false

) : ObservableBoolean(default) {

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

	override fun get(): Boolean = preferences.getBoolean(key, default)

	override fun set(value: Boolean) {
		preferences[key] = value
	}
}