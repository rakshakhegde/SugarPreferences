package io.github.rakshakhegde.sugarprefs

/**
 * Created by rakshakhegde on 07/03/17.
 */
interface SugarAccessorInterface<V> {

	fun get(): V

	fun set(value: V)

	fun notifyChange()
}
