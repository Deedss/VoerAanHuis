package states

class Arrived : StatusState() {
    override fun nextState(): StatusState {
        return Arrived()
    }

    override fun prevState(): StatusState {
        return OnRoute()
    }
}