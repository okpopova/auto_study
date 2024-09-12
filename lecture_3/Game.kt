package lessons.lecture_3

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    gameResult(userChoice,gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()].lowercase()

fun getUserChoice(optionsParam: Array<String>): String {
    var choice: String = ""
    var isValid = false
    printParams(optionsParam)
    while (!isValid) {
        choice = readln()
        isValid = validateChoice(choice, optionsParam)

        if (!isValid) {
            println("Введите корректное значение")
        }
    }
    return choice.lowercase()
}

fun validateChoice(choice: String, possibleChoices: Array<String>): Boolean {
    var isValid = false
    val choiceLowerCased = choice.lowercase()
    for (possibleChoice in possibleChoices) {
        val possibleChoiceLowerCased = possibleChoice.lowercase()
        if (choiceLowerCased == possibleChoiceLowerCased) {
            isValid = true
        }
    }
    return isValid
}

fun printParams(optionsParam: Array<String>): Unit {
    print("Выберите один из вариантов: ")
    for (i in optionsParam.indices) {
        val x = optionsParam[i]
        if (i != optionsParam.size - 1) {
            print("$x, ")
        } else {
            print(x)
        }
    }
    println()
}

fun gameResult(userChoice: String, gameChoice: String): Unit {
    println("Ваш выбор: $userChoice")
    println("Выбор компьютера: $gameChoice")
    when (rule(userChoice, gameChoice)) {
        "Победа" -> println("Поздравляем! Вы супер!")
        "Проигрыш" -> println("Вы проиграли :(")
        "Ничья" -> println("Ничья!")
        else -> println("Что-то пошло не так")
    }
}

fun rule(variant1: String, variant2: String): String {
    if (variant1 == variant2) return "Ничья"
    when (variant1) {
        "paper" -> return if (variant2 == "rock") "Победа" else "Проигрыш"
        "rock" -> return if (variant2 == "scissors") "Победа" else "Проигрыш"
        "scissors" -> return if (variant2 == "paper") "Победа" else "Проигрыш"
        else -> return "Проигрыш"
    }
}