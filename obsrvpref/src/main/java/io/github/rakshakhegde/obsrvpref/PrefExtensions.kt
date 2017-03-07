package io.github.rakshakhegde.obsrvpref

import android.content.SharedPreferences

/**
 * Created by rakshakhegde on 07/03/17.
 */

operator fun SharedPreferences.set(key: String, boolValue: Boolean) {
	edit().putBoolean(key, boolValue).apply()
}

operator fun SharedPreferences.set(key: String, floatValue: Float) {
	edit().putFloat(key, floatValue).apply()
}

operator fun SharedPreferences.set(key: String, intValue: Int) {
	edit().putInt(key, intValue).apply()
}

operator fun SharedPreferences.set(key: String, stringValue: String) {
	edit().putString(key, stringValue).apply()
}