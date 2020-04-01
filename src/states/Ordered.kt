package states

class Ordered : StatusState() {
    override var description: String = "Ordered"

    override fun nextState(): StatusState {
        return Preparing()
    }

    override fun prevState(): StatusState {
        return Ordered()
    }
}