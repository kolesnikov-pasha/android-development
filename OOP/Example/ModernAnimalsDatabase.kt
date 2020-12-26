class ModernAnimalsDatabase : AnimalsDatabase() {
    override fun requestAnimals(): Array<Animal> {
        return arrayOf(
            Cat("Котофейкин", 123124)
        )
    }
}