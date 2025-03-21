package org.example.domain.wiseSaying.repository

import org.example.domain.wiseSaying.entity.WiseSaying

interface WiseSayingRepository {
    fun save(wiseSaying: WiseSaying): WiseSaying
    fun findAll(): List<WiseSaying>
    fun findById(id: Int): WiseSaying?
    fun delete(wiseSaying: WiseSaying)
    fun clear()
}