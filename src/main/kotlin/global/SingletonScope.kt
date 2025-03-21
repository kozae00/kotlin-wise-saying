package com.think.global

import com.think.domain.system.controller.SystemController
import com.think.domain.wiseSaying.controller.WiseSayingController
import com.think.domain.wiseSaying.repository.WiseSayingRepository
import com.think.domain.wiseSaying.service.WiseSayingService

object SingletonScope {
    val wiseSayingRepository = WiseSayingRepository()
    val wiseSayingService = WiseSayingService()
    val wiseSayingController = WiseSayingController()
    val systemController = SystemController()
}