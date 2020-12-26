fun main() {
    val cat: MovableAnimal = Cat("Барсик", 15)
    val bird: MovableAnimal = Bird("Наташа")
    val eagle: MovableAnimal = Eagle("Алексей")
    println(cat::class.simpleName)
    println(bird::class.simpleName)

    bird.printInfo()
    bird.move(10001, 8082)
    bird.printInfo()

    println()

    eagle.printInfo()
    eagle.increaseAge()
    eagle.saySomething()
    eagle.printInfo()

    println()

    cat.printInfo()
    cat.increaseAge()
    cat.move(10, 4)
    cat.printInfo()
    cat.saySomething()

    // SOLID

    val reporter = ModernAnimalsReporter()
    val database = AnimalsDatabase()

    println("-------------")
    reporter.report()
    println("-------------")
    reporter.postAnimals(database.requestAnimals())
    reporter.report()
}