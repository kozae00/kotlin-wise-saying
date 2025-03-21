class AppTest {

    @Test
    fun `명언 등록`() {
        val out = TestBot.run(
            """
                 등록
                 인생은 짧고, 예술은 길다.
                 헨리 장
             """
        )

        assertThat(out).contains("명언:")
        assertThat(out).contains("작가:")
        assertThat(out).contains("1번 명언이 등록되었습니다.")
    }

}