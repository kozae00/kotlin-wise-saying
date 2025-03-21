package org.example.domain.wiseSaying.entity

data class WiseSaying(
    val id: Int = 0,
    val saying: String,
    val author: String
) {
    fun isNew(): Boolean {
        return id == 0
    }

    val jsonStr: String
        get() = """
             {
                 "id": $id,
                 "saying": "$saying",
                 "author": "$author"
             }
         """.trimIndent()
}

