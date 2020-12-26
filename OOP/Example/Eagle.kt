class Eagle(
    private val name: String
) : Bird(name) {

    override fun saySomething() {
        println("Жив, цел, орел!")
    }

    override fun printInfo() {
        println("Имя ОРЛИЩА $name, а его возраст - $ageInDays дней")
    }
}