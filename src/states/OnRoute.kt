package states

/**
 * OnRoute StatusState, indicating that product is onRoute to Customer.
 */
class OnRoute : StatusState() {
    override var description: String = "OnRoute"

    override fun nextState(): StatusState {
        return Arrived()
    }

    override fun prevState(): StatusState {
        return Preparing()
    }
}