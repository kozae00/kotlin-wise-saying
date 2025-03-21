package org.example.global

import org.example.domain.system.controller.SystemController
import org.example.domain.wiseSaying.controller.WiseSayingController
import org.example.domain.wiseSaying.repository.WiseSayingRepository
import org.example.domain.wiseSaying.service.WiseSayingService


object SingletonScope {
    val wiseSayingRepository by lazy { WiseSayingRepository() }
    val wiseSayingService by lazy { WiseSayingService() }
    val wiseSayingController by lazy { WiseSayingController() }
    val systemController by lazy { SystemController() }
}