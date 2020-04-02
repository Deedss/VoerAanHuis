package states

/**
 * Preparing StatusState, indicating that order is being prepared.
 */
class Preparing : StatusState() {
    override var description: String = "Preparing"

    override fun nextState(): StatusState {
        return OnRoute()
    }

    override fun prevState(): StatusState {
        return Ordered()
    }
}