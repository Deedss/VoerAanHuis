package states

abstract class StatusState {
    abstract fun nextState() : StatusState
    abstract fun prevState() : StatusState
}