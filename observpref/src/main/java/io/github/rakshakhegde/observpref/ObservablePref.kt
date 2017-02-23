package io.github.rakshakhegde.observpref

import android.content.Context
import android.content.SharedPreferences
import android.databinding.ObservableField
import android.preference.PreferenceManager

/**
 * Created by rakshakhegde on 23/02/17.
 */
abstract class ObservablePref<T>(ctx: Context, key: String) : ObservableField<T>() {

	private val appCtx = ctx.applicationContext
	protected val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appCtx)

	private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, _key ->
		if (_key == key) {
			notifyChange()
		}
	}

	init {
		defaultSharedPreferences.registerOnSharedPreferenceChangeListener(prefListener)
	}

	abstract override fun get(): T

	abstract override fun set(value: T)
}