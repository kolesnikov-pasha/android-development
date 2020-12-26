class Coral : Animal {
    private var age = 0

    override fun saySomething() {
        println("Буль-буль")
    }

    override fun increaseAge() {
        age++
    }

    override fun printInfo() {
        println("Коралл: возраст = $age")
    }
}