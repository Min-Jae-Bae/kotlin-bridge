package bridge.utils

// Bridge
const val FIRST_ROUND = 0
const val FIRST_TRY = 1
const val TWO_BRIDGE = 2
const val MIN_BRIDGE_SIZE = 3
const val MAX_BRIDGE_SIZE = 21

// Message
const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
const val SELECT_MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
const val SELECT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
const val FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과"
const val WHETHER_GAME_SUCCESS_MESSAGE = "게임 성공 여부: %s"
const val ATTEMPTS_TOTAL_MESSAGE = "총 시도한 횟수: %d"

// Error
const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다."
const val ERROR_INVALID_MOVE_MESSAGE = "[ERROR] U와 D만 이동 입력이 가능합니다."
const val ERROR_INVALID_COMMAND_MESSAGE = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다"

// Command
const val QUIT_COMMAND = "Q"
const val RESTART_COMMAND = "R"

// pass
const val PASS_POSSIBLE_EXPRESSION = "O"
const val PASS_IMPOSSIBLE_EXPRESSION = "X"
const val CROSSING_FAIL_OUTPUT = "실패"
const val CROSSING_SUCCESS_OUTPUT = "성공"

// sign
const val EMPTY_EXPRESSION = " "
const val OPEN_BRACKET ="[ "
const val CLOSE_BRACKET =" ]\n"
const val VERTICAL_LINE = " | "



