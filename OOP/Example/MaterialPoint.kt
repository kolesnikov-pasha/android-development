class MaterialPoint: Movable {
    private var x = 0
    private var y = 0

    override fun move(distanceX: Int, distanceY: Int) {
        x += distanceX
        y += distanceY
    }
}