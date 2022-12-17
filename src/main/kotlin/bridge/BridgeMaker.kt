package bridge

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.utils.Moving


class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge: MutableList<String> = mutableListOf()
        repeat(size) {
            when (bridgeNumberGenerator.generate()) {
                RANDOM_UPPER_INCLUSIVE -> bridge.add(Moving.UP.command)
                RANDOM_LOWER_INCLUSIVE -> bridge.add(Moving.DOWN.command)
            }
        }
        return bridge
    }
}
