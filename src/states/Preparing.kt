package states

class Preparing : StatusState() {
    override fun nextState(): StatusState {
        return OnRoute()
    }

    override fun prevState(): StatusState {
        return Ordered()
    }
}