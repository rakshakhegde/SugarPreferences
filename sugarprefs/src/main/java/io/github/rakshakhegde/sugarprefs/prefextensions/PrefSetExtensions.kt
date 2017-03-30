package io.github.rakshakhegde.sugarprefs.prefextensions

import android.annotation.SuppressLint
import android.content.SharedPreferences

/**
 * Created by rakshakhegde on 07/03/17.
 */

operator fun SharedPreferences.set(key: String, boolVal: Boolean) {
	edit().putBoolean(key, boolVal).apply()
}

operator fun SharedPreferences.set(key: String, floatVal: Float) {
	edit().putFloat(key, floatVal).apply()
}

operator fun SharedPreferences.set(key: String, intVal: Int) {
	edit().putInt(key, intVal).apply()
}

operator fun SharedPreferences.set(key: String, stringVal: String?) {
	edit().putString(key, stringVal).apply()
}

@SuppressLint("NewApi")
operator fun SharedPreferences.set(key: String, stringSetVal: Set<String>) {
	edit().putStringSet(key, stringSetVal).apply()
}
