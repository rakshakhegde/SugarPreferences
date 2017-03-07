package io.github.rakshakhegde.obsrvpref

/**
 * Created by rakshakhegde on 28/02/17.
 */

/**
 * Creates a new instance of the [Lazy] that uses the specified initialization function [initializer]
 * and the default thread-safety mode [LazyThreadSafetyMode.SYNCHRONIZED].
 *
 * If the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.
 *
 * Note that the returned instance uses itself to synchronize on. Do not synchronize from external code on
 * the returned instance as it may cause accidental deadlock. Also this behavior can be changed in the future.
 */
inline fun <T, R> T.lazyExt(crossinline initializer: T.() -> R): Lazy<R> =
		lazy { initializer() }

/**
 * Creates a new instance of the [Lazy] that uses the specified initialization function [initializer]
 * and the default thread-safety mode [LazyThreadSafetyMode.SYNCHRONIZED].
 *
 * If the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.
 *
 * The returned instance uses the specified [lock] object to synchronize on.
 * When the [lock] is not specified the instance uses itself to synchronize on,
 * in this case do not synchronize from external code on the returned instance as it may cause accidental deadlock.
 * Also this behavior can be changed in the future.
 */
inline fun <T, R> T.lazyExt(lock: Any?, crossinline initializer: T.() -> R): Lazy<R> =
		lazy(lock) { initializer() }

/**
 * Creates a new instance of the [Lazy] that uses the specified initialization function [initializer]
 * and thread-safety [mode].
 *
 * If the initialization of a value throws an exception, it will attempt to reinitialize the value at next access.
 *
 * Note that when the [LazyThreadSafetyMode.SYNCHRONIZED] mode is specified the returned instance uses itself
 * to synchronize on. Do not synchronize from external code on the returned instance as it may cause accidental deadlock.
 * Also this behavior can be changed in the future.
 */
inline fun <T, R> T.lazyExt(mode: LazyThreadSafetyMode, crossinline initializer: T.() -> R): Lazy<R> =
		lazy(mode) { initializer() }

