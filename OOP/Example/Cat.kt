class Cat(
    private val name: String,
    private val color: Int
) : MovableAnimal {
    private var age: Int = 0
    private var x = 0
    private var y = 0

    init {
        saySomething()
    }

    fun mur() {
        println("Murrrrr")
    }

    fun mur(howManyTimes: Int) {
        repeat(howManyTimes) {
            mur()
        }
    }

    override fun move(distanceX: Int, distanceY: Int) {
        x += distanceX
        y += distanceY
    }

    override fun saySomething() {
        println("Мяу!")
    }

    override fun printInfo() {
        println(buildInfo())
    }

    override fun increaseAge() {
        age++
    }

    private fun buildInfo(): String {
        return "Котенок $name, возраст - $age, цвет - $color, находится в точке {$x; $y}"
    }
}