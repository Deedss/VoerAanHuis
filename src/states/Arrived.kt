package states

class Arrived : StatusState() {
    override var description: String = "Arrived"
    override fun nextState(): StatusState {
        return Arrived()
    }

    override fun prevState(): StatusState {
        return OnRoute()
    }
}