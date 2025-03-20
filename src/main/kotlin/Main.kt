package org.example

import org.example.domain.wiseSaying.entity.WiseSaying

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val wiseSayings = mutableListOf<WiseSaying>()

    var lastId = 0

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
                val id = lastId ++
                wiseSayings.add(WiseSaying(id, saying, author))

                println("${lastId}번 명언이 등록되었습니다.")
            }
            "목록" -> {
                println("번호 / 명언 / 작가")
                println("----------------------")
                wiseSayings.forEach {
                    println("${it.id} / ${it.saying} / ${it.author}")
                }
            }
        }
    }
}