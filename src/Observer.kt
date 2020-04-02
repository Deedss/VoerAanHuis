/**
 * Abstract class Observer to update all observers.
 */
abstract class Observer {
    abstract fun update(order: Order)
}