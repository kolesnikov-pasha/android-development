open class AnimalsDatabase {
    private val animals = Array(4) {
        when (it) {
            0 -> Cat("Мурзик", 10)
            1 -> Eagle("Владимир")
            2 -> Bird("Алена")
            3 -> Cat("Шерстянуха", 0)
            else -> Bird("default bird")
        }
    }

    open fun requestAnimals(): Array<Animal> = animals
}