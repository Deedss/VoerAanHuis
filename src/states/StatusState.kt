package states

abstract class StatusState {
    abstract var description : String
    abstract fun nextState() : StatusState
    abstract fun prevState() : StatusState
}