package io.github.rakshakhegde.observpref

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableFloat
import android.preference.PreferenceManager

/**
 * Created by rakshakhegde on 23/02/17.
 */

class ObservableFloatPref @JvmOverloads constructor(ctx: Context, val key: String, val default: Float = 0F) :
		ObservableFloat(default) {

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

	override fun get(): Float = preferences.getFloat(key, default)

	override fun set(value: Float) {
		preferences.edit().putFloat(key, value).apply()
	}
}