package bridge.view.validator

object InputValidator {

    fun validateInvalidSize(): Int {
        while (true) {
            try {
                println("다리의 길이를 입력해주세요.")
                val bridgeSize = readLine()!!.toInt()
                require(bridgeSize > 2 && bridgeSize < 21)
                return bridgeSize
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 유효하지 않은 숫자입니다. 다시 입력해주세요")
                continue
            }
        }
    }

    fun validateInvalidMoving(): String {
        while (true) {
            try {
                println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
                val moving = readLine()!!
                require(moving == "U" || moving == "D")
                return moving
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 유효하지 않은 숫자입니다. 다시 입력해주세요")
                continue
            }
        }
    }

    fun validateInvalidGameCommand(): String {
        while (true) {
            try {
                println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
                val gameCommand = readLine()!!
                require(gameCommand == "Q" || gameCommand == "R")
                return gameCommand
            } catch (e: IllegalArgumentException) {
                println("[ERROR] 유효하지 않은 숫자입니다. 다시 입력해주세요")
                continue
            }
        }
    }
}