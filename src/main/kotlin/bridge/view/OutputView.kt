package bridge.view


class OutputView {

    fun printMap(bridge: List<String>) {
        bridge.forEach { bridgeMap -> println(bridgeMap) }
    }



    fun printResult(bridge: List<String>, whether: Boolean, attemptsTotal: Int) {
        println("최종 게임 결과")
        println(bridge)
        println("게임 성공 여부: $whether")
        println("총 시도한 횟수: $attemptsTotal")
    }
}
