package io.github.rakshakhegde.observpref

import android.content.Context

/**
 * Created by rakshakhegde on 23/02/17.
 */

fun Context.observableStringPref(key: String, default: String = "") =
		ObservableStringPref(this, key, default)