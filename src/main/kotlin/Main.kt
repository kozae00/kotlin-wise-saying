package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    println("== 명언 앱 ==")

    while(true) {
        println("명령) ")
        val input = readlnOrNull() ?: ""

        when(input) {
            "종료" -> break
            "등록" -> {
                print("명언: ")
                val saying = readlnOrNull() ?: ""
                print("작가: ")
                val author = readlnOrNull() ?: ""

                println("${saying} : ${author} 명언이 등록되었습니다.")
            }
        }
    }
}