package org.example.domain.wiseSaying.repository

import org.example.domain.wiseSaying.entity.WiseSaying
import org.example.global.AppConfig
import org.example.standard.JsonUtil
import java.nio.file.Path

class WiseSayingFileRepository : WiseSayingRepository {

    init {
        initTable()
    }

    val tableDirPath: Path
        get() = AppConfig.tableDirPath.resolve("wiseSaying")

    override fun save(wiseSaying: WiseSaying): WiseSaying {

        val target = if (wiseSaying.isNew()) wiseSaying.copy(id = getNextId()) else  wiseSaying

        return target.also {
            saveOnDisk(it)
        }
    }

    private fun saveOnDisk(wiseSaying: WiseSaying) {
        tableDirPath.resolve("${wiseSaying.id}.json").toFile().writeText(wiseSaying.jsonStr)
    }

    override fun findAll(): List<WiseSaying> {
        return tableDirPath.toFile()
            .listFiles()
            ?.filter { it.extension == "json"}
            ?.map { WiseSaying.fromJson(it.readText()) }
            .orEmpty()
    }

    override fun findById(id: Int): WiseSaying? {
        return tableDirPath.resolve("${id}.json").toFile()
            .takeIf { it.exists() }
            ?.let {
                WiseSaying.fromJson(it.readText())
            }
    }

    override fun delete(wiseSaying: WiseSaying) {
        tableDirPath.resolve("${wiseSaying.id}.json").toFile().delete()
    }

    override fun clear() {
        tableDirPath.toFile().deleteRecursively()
    }

    fun saveLastId(id: Int) {
        tableDirPath.resolve("lastId.txt").toFile().writeText(id.toString())
    }

    fun loadLastId(): Int {
        tableDirPath.resolve("lastId.txt").toFile().run {
            if(!exists()) {
                return 1
            }
            return readText().toInt()
        }
    }

    private fun getNextId(): Int {
        return loadLastId().also {
            saveLastId(it + 1)
        }
    }

    fun initTable() {
        tableDirPath.toFile().run {
            if(!exists()) {
                mkdirs()
            }
        }
    }

    fun build() {
        val mapList = findAll().map {
            it.map
        }

        JsonUtil.listToJson(mapList).also {
            tableDirPath.resolve("data.json").toFile().writeText(it)
        }

    }
}