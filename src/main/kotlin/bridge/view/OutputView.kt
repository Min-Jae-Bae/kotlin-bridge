package bridge.view


class OutputView {

    fun printMap(bridgeMap: List<String>) {
        bridgeMap.forEach { bridgeMapMap -> println(bridgeMapMap) }
    }



    fun printResult(bridgeMap: List<String>, whether: String, attemptsTotal: Int) {
        println("최종 게임 결과")
        printMap(bridgeMap)
        println("게임 성공 여부: $whether")
        println("총 시도한 횟수: $attemptsTotal")
    }
}
