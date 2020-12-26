open class AnimalsReporter {
    var animals: Array<Animal>? = null

    fun report() {
        animals?.let {
            for (animal in it) {
                animal.printInfo()
            }
        }
    }

    open fun postAnimals(animals: Array<Animal>?) {
        this.animals = animals
    }
}