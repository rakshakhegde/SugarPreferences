package io.github.rakshakhegde.observpref

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableInt
import android.preference.PreferenceManager

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObsrvIntPref @JvmOverloads constructor(ctx: Context, val key: String, val default: Int = 0) :
		ObservableInt(default) {

	private val appCtx = ctx.applicationContext
	protected val preferences = PreferenceManager.getDefaultSharedPreferences(appCtx)

	private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, _key ->
		if (_key == key) {
			notifyChange()
		}
	}

	init {
		preferences.registerOnSharedPreferenceChangeListener(prefListener)
	}

	override fun get(): Int = preferences.getInt(key, default)

	override fun set(value: Int) {
		preferences.edit().putInt(key, value).apply()
	}
}