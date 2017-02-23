package io.github.rakshakhegde.observpref

import android.content.Context

/**
 * Created by rakshakhegde on 23/02/17.
 */
class ObservableStringPref(ctx: Context, val key: String, val default: String = "") :
		ObservablePref<String>(ctx, key) {

	override fun get(): String = defaultSharedPreferences.getString(key, default)

	override fun set(value: String) {
		defaultSharedPreferences.edit().putString(key, value).apply()
	}
}