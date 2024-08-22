package lessons.lecture_1

fun main(){
    val a=3
    val b=1
    println(if (a>b) "a is greater than b" else "a is not greater than b")
    println("This line runs no matter what")

    var x = 1
    while (x<3){
        print(if (x ==1) "Yab" else "Dab")
        print("ba")
        x=x+1
    }
    if (x==3) println("Do")
}