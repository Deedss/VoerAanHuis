package states

class Ordered : StatusState() {
    override fun nextState(): StatusState {
        return Preparing()
    }

    override fun prevState(): StatusState {
        return Ordered()
    }
}