class ModernAnimalsReporter : AnimalsReporter() {

    override fun postAnimals(animals: Array<Animal>?) {
        super.postAnimals(animals)
        report()
    }

}