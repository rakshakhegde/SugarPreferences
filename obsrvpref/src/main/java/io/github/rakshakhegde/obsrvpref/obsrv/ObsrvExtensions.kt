package io.github.rakshakhegde.obsrvpref.obsrv

import android.content.Context

/**
 * Created by rakshakhegde on 23/02/17.
 */

fun Context.obsrvBoolPref(key: String, default: Boolean = false) =
		ObsrvBoolPref(this, key, default)

fun Context.obsrvFloatPref(key: String, default: Float = 0F) =
		ObsrvFloatPref(this, key, default)

fun Context.obsrvIntPref(key: String, default: Int = 0) =
		ObsrvIntPref(this, key, default)

fun Context.obsrvStringPref(key: String, default: String = "") =
		ObsrvStringPref(this, key, default)