package bridge

import bridge.game.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val bridgeGame = BridgeGame(BridgeMaker(BridgeRandomNumberGenerator()), InputView(), OutputView())
    bridgeGame.play()
}
