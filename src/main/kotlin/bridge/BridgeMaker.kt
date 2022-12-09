package bridge


class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge: MutableList<String> = mutableListOf()
        repeat(size) {
            when (bridgeNumberGenerator.generate()) {
                1 -> bridge.add("U")
                0 -> bridge.add("D")
            }
        }
        return bridge
    }
}
