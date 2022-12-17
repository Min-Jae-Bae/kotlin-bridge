package bridge.model

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.utils.*

object BridgeGameProcessor {

    private val bridgePassingInfo: MutableList<Pair<Moving, Boolean>> = mutableListOf()
    private val bridgeList: HashMap<Int, String> =
        hashMapOf(
            RANDOM_LOWER_INCLUSIVE to Moving.UP.command,
            RANDOM_UPPER_INCLUSIVE to Moving.DOWN.command
        )
    private val bridgeCurrentMap: MutableList<String> = mutableListOf()

    fun clearPassingInfo() = bridgePassingInfo.clear()

    fun isCrossingFail(): Boolean = bridgePassingInfo.any { (_, hasPassed) -> !hasPassed }

    fun updatePassingInfo(moving: Moving, hasPassed: Boolean) {
        bridgePassingInfo.add(Pair(moving, hasPassed))
    }


    private fun createCrossingAnswer(
        moving: Moving,
        userMoving: String,
        hasPassed: Boolean,
    ): String {
        val crossingAnswer = when (moving.command) {
            userMoving -> if (hasPassed) PASS_POSSIBLE_EXPRESSION else PASS_IMPOSSIBLE_EXPRESSION
            else -> EMPTY_EXPRESSION
        }
        return crossingAnswer
    }

    private fun createResult(userMoving: String): String {
        var resultPrint = OPEN_BRACKET
        var round = bridgePassingInfo.size - 1

        bridgePassingInfo.forEachIndexed { index, (moving, hasPassed) ->
            resultPrint += createCrossingAnswer(moving, userMoving, hasPassed)
            resultPrint += if (round == index) CLOSE_BRACKET else VERTICAL_LINE
        }
        return resultPrint
    }

    fun updateCurrentMap(): List<String> {
        bridgeCurrentMap.clear()
        repeat(TWO_BRIDGE) { twoBridge ->
            bridgeCurrentMap.add(createResult(bridgeList[twoBridge]!!))
        }
        return bridgeCurrentMap
    }
}