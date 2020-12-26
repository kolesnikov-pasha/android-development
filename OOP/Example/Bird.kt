open class Bird(
    private val name: String
) : MovableAnimal {
    internal var ageInDays = 0
    private var x = 0
    private var y = 0

    override fun saySomething() {
        println("Чирик-чирик!")
    }

    override fun increaseAge() {
        ageInDays += 365
    }

    override fun printInfo() {
        println("Имя птичечки $name, а ее возраст - $ageInDays дней")
    }

    override fun move(distanceX: Int, distanceY: Int) {
        x += distanceX
        y += distanceY
    }
}