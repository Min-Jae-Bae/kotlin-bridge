package bridge.view

import bridge.view.validator.InputValidator


class InputView {

    fun readBridgeSize(): Int {
        return InputValidator.validateInvalidSize()
    }


    fun readMoving(): String {
        return InputValidator.validateInvalidMoving()
    }


    fun readGameCommand(): String {
        return InputValidator.validateInvalidGameCommand()
    }
}
