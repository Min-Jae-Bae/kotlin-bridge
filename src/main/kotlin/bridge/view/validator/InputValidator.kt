package bridge.view.validator

import bridge.utils.*

object InputValidator {

    fun validateInvalidSize(): Int {
        while (true) {
            try {
                println(INPUT_BRIDGE_SIZE_MESSAGE)
                val bridgeSize = readLine()!!.toInt()
                require(bridgeSize in MIN_BRIDGE_SIZE until MAX_BRIDGE_SIZE)
                return bridgeSize
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_SIZE_MESSAGE)
                continue
            }
        }
    }

    fun validateInvalidMoving(): String {
        while (true) {
            try {
                println(SELECT_MOVE_INPUT_MESSAGE)
                val moving = readLine()!!
                require(moving == Moving.UP.command || moving == Moving.DOWN.command)
                return moving
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_MOVE_MESSAGE)
                continue
            }
        }
    }

    fun validateInvalidGameCommand(): String {
        while (true) {
            try {
                println(SELECT_GAME_COMMAND_MESSAGE)
                val gameCommand = readLine()!!
                require(gameCommand == QUIT_COMMAND || gameCommand == RESTART_COMMAND)
                return gameCommand
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_COMMAND_MESSAGE)
                continue
            }
        }
    }
}