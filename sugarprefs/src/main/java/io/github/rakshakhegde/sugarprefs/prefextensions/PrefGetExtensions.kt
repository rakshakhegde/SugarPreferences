package io.github.rakshakhegde.sugarprefs.prefextensions

import android.annotation.SuppressLint
import android.content.SharedPreferences

/**
 * Created by rakshakhegde on 07/03/17.
 */

operator fun SharedPreferences.get(key: String, defaultBool: Boolean) =
		getBoolean(key, defaultBool)

operator fun SharedPreferences.get(key: String, defaultFloat: Float) =
		getFloat(key, defaultFloat)

operator fun SharedPreferences.get(key: String, defaultInt: Int) =
		getInt(key, defaultInt)

operator fun SharedPreferences.get(key: String, defaultLong: Long) =
		getLong(key, defaultLong)

operator fun SharedPreferences.get(key: String, defaultString: String?): String? =
		getString(key, defaultString)

@SuppressLint("NewApi")
operator fun SharedPreferences.get(key: String, defaultStringSet: Set<String>) =
		getStringSet(key, defaultStringSet)