package bridge.model

import bridge.utils.Moving

object BridgeGameProcessor {

    //TODO: 입력에 따른 통과, 미통과 정보, 두개의 다리, 현재 결과를 담은 리스트 필요
    private val bridgePassingInfo: MutableList<Pair<Moving, Boolean>> = mutableListOf()
    private val bridgeList: HashMap<Int, String> = hashMapOf(0 to "U", 1 to "D")
    private val bridgeCurrentMap: MutableList<String> = mutableListOf()

    //TODO: 정보를 지우는 기능, 통과하지 못했을 때를 true를 반환하는 기능, 통과, 미통과를 넣는 기능

    fun clearPassingInfo() = bridgePassingInfo.clear()
    fun isCrossingFail(): Boolean = bridgePassingInfo.any { (_, hasPassed) -> !hasPassed }
    fun updatePassingInfo(moving: Moving, hasPassed: Boolean) {
        bridgePassingInfo.add(Pair(moving, hasPassed))
    }

    // TODO: O, X 제작 기능, 출력틀 제작 기능, 2개 다리에 결과를 넣는 기능

    private fun createCrossingAnswer(moving: Moving, userMoving: String, hasPassed: Boolean): String {
        val crossingAnswer = when (moving.command) {
            userMoving -> if (hasPassed) "O" else "X"
            else -> " "
        }
        return crossingAnswer
    }

    private fun createResult(userMoving: String): String {
        var resultPrint = "[ "
        var round = bridgePassingInfo.size - 1

        bridgePassingInfo.forEachIndexed { index, (moving, hasPassed) ->
            resultPrint += createCrossingAnswer(moving, userMoving, hasPassed)
            resultPrint += if (round == index) " ]" else " | "
        }
        return resultPrint
    }

    fun updateCurrentMap(): List<String> {
        bridgeCurrentMap.clear()
        repeat(2) {  twoBridge ->
            bridgeCurrentMap.add(createResult(bridgeList[twoBridge]!!))
        }
        return bridgeCurrentMap
    }
}