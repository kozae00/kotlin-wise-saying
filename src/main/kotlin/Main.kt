package org.example

import org.example.domain.system.controller.SystemController
import org.example.domain.wiseSaying.controller.WiseSayingController
import org.example.global.Request

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val wiseSayingController = WiseSayingController()
    val systemController = SystemController()

    println("== 명언 앱 ==")
    while (true) {
        print("명령) ")
        val input = readlnOrNull() ?: ""

        val rq = Request(input)

        when (rq.actionName) {
            "종료" -> {
                systemController.exit()
                break
            }
            "등록" -> wiseSayingController.write()
            "목록" -> wiseSayingController.list()
            "삭제" -> wiseSayingController.delete(rq)
            else -> {
                println("알 수 없는 명령입니다.")
            }
        }
    }
}