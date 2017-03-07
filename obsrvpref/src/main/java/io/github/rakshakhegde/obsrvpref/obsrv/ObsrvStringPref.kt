package io.github.rakshakhegde.obsrvpref.obsrv

import android.content.Context
import io.github.rakshakhegde.obsrvpref.set

/**
 * Created by rakshakhegde on 23/02/17.
 */
class ObsrvStringPref(ctx: Context, val key: String, val default: String = "") :
		ObsrvPref<String>(ctx, key) {

	override fun get(): String = preferences.getString(key, default)

	override fun set(value: String) {
		preferences[key] = value
	}
}