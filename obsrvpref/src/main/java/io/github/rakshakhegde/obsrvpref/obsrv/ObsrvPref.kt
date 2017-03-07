package io.github.rakshakhegde.obsrvpref.obsrv

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableField
import android.preference.PreferenceManager

/**
 * Created by rakshakhegde on 23/02/17.
 */
abstract class ObsrvPref<T>(ctx: Context, key: String) : ObservableField<T>() {

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

	abstract override fun get(): T

	abstract override fun set(value: T)
}