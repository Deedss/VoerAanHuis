package states

/**
 * Arrived StatusState, product has arrived
 */
class Arrived : StatusState() {
    override var description: String = "Arrived"
    override fun nextState(): StatusState {
        return Arrived()
    }

    override fun prevState(): StatusState {
        return OnRoute()
    }
}