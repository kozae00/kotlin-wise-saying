package domain.wiseSaying.repository

import org.example.domain.wiseSaying.entity.WiseSaying
import org.example.global.SingletonScope.wiseSayingRepository
import org.junit.jupiter.api.Test

class WiseSayingRepositoryTest {

    @Test
    fun `save`() {
        val wiseSaying = wiseSayingRepository
            .save(WiseSaying(saying = "인생은 짧고, 예술은 길다.", author = "헨리 장"))

        val filePath = wiseSayingRepository
            .tableDirPath
            .toFile()
            .listFiles()
            ?.find { it.name == "${wiseSaying.id}.json" }

        assertThat(filePath).isNotNull
    }
}