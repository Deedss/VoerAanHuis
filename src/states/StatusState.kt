package states

/**
 * abstract StatusState class for status of the order.
 */
abstract class StatusState {
    abstract var description : String
    abstract fun nextState() : StatusState
    abstract fun prevState() : StatusState
}