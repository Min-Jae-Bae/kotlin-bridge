package bridge.game

import bridge.BridgeMaker
import bridge.game.service.Game
import bridge.model.BridgeGameProcessor
import bridge.utils.*
import bridge.view.InputView
import bridge.view.OutputView


class BridgeGame(
    private val bridgeMaker: BridgeMaker,
    private val inputView: InputView,
    private val outputView: OutputView,
) : Game {
    private lateinit var bridge: List<String>
    private var round = FIRST_ROUND
    private var attemptsTotal = FIRST_TRY

    override fun play() {
        initGame()
        process()
    }

    private fun initGame() {
        println(GAME_START_MESSAGE)
        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    override fun process() {
        do {
            move()
            moveUnable()
            completeMission()
        } while (round < bridge.size)
    }


    private fun move() {
        val inputMove = inputView.readMoving()
        val moveResult = if (inputMove == Moving.UP.command) Moving.UP else Moving.DOWN
        val hasPassed = (inputMove == moveResult.command)

        BridgeGameProcessor.updatePassingInfo(moveResult, hasPassed)

        outputView.printMap(BridgeGameProcessor.updateCurrentMap())
        round++
    }

    private fun moveUnable() {
        if (BridgeGameProcessor.isCrossingFail()) {
            when (inputView.readGameCommand()) {
                QUIT_COMMAND -> quit()
                RESTART_COMMAND -> retry()
            }
        }
    }


    override fun quit() {
        val whetherResult = if (BridgeGameProcessor.isCrossingFail()) CROSSING_FAIL_OUTPUT else CROSSING_SUCCESS_OUTPUT
        outputView.printResult(BridgeGameProcessor.updateCurrentMap(), whetherResult, attemptsTotal)
    }

    private fun retry() {
        BridgeGameProcessor.clearPassingInfo()
        round = FIRST_ROUND
        attemptsTotal++
    }

    private fun completeMission() {
        if (round == bridge.size) {
            if (!BridgeGameProcessor.isCrossingFail()) {
                quit()
            }
        }
    }

}
