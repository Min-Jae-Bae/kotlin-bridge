package bridge.view

import bridge.utils.ATTEMPTS_TOTAL_MESSAGE
import bridge.utils.FINAL_GAME_RESULT_MESSAGE
import bridge.utils.WHETHER_GAME_SUCCESS_MESSAGE


class OutputView {

    fun printMap(bridgeMap: List<String>) {
        bridgeMap.forEach { bridgeMapMap -> println(bridgeMapMap) }
    }



    fun printResult(bridgeMap: List<String>, whether: String, attemptsTotal: Int) {
        println(FINAL_GAME_RESULT_MESSAGE)
        printMap(bridgeMap)
        println(WHETHER_GAME_SUCCESS_MESSAGE.format(whether))
        println(ATTEMPTS_TOTAL_MESSAGE.format(attemptsTotal))
    }

}
