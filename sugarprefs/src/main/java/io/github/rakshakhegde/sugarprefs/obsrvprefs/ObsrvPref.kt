package io.github.rakshakhegde.sugarprefs.obsrvprefs

import android.content.SharedPreferences
import android.databinding.ObservableField
import io.github.rakshakhegde.sugarprefs.PreferenceHelper
import io.github.rakshakhegde.sugarprefs.SugarPrefImpl

/**
 * Created by rakshakhegde on 23/02/17.
 */
abstract class ObsrvPref<T> @JvmOverloads constructor(
		key: String,
		preferences: SharedPreferences = PreferenceHelper.defaultPrefs
) : ObservableField<T>() {

	val sugarPref = SugarPrefImpl(this, key, preferences)

	abstract override fun get(): T

	abstract override fun set(value: T)
}
