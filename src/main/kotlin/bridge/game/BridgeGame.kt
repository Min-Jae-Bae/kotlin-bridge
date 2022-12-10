package bridge.game

import bridge.BridgeMaker
import bridge.game.service.Game
import bridge.model.BridgeGameProcessor
import bridge.utils.Moving
import bridge.view.InputView
import bridge.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeMaker: BridgeMaker,
    private val inputView: InputView,
    private val outputView: OutputView,
) : Game {
    /*TODO: bridge에 접근하기 위해 리스트 접근, 게임 라운드 0부터 시작, 시도는 1부터 시작*/
    private lateinit var bridge: List<String>
    private var round = 0
    private var attemptsTotal = 1

    override fun play() {
        /*TODO: 초기 게임을 설정하고, 진행*/
        initGame()
        process()
    }

    private fun initGame() {
        /*TODO: 다리 길이를 입력하고 다리를 생성*/
        println("다리 건너기 게임을 시작합니다.")
        val bridgeSize = inputView.readBridgeSize()
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    override fun process() {
        do {
            /*TODO: 이동(이동할 수 없을 때, 미션을 완료했을 때)*/
            move()
            moveUnable()
            completeMission()
        } while (round < bridge.size)
    }


    private fun move() {
        /*TODO: 이동칸 입력 -> 결과 업데이트 -> 출력 -> 라운드 증가*/

        round++
    }

    private fun moveUnable() {
        /*TODO: 지니가는게 실패할 때 -> 커멘드 입력 -> quit, retry 호출*/

        when (inputView.readGameCommand()) {
            "Q" -> quit()
            "R" -> retry()
        }
    }


    override fun quit() {
        /*TODO: 성공 or 실패 -> 현재맵 업데이트 -> printResult 출력*/
    }

    private fun retry() {
        /*TODO: 깨끗히 지우기 -> round 초기화 -> 시도 횟수 증가*/
        round = 0
        attemptsTotal++
    }

    private fun completeMission() {
        /*TODO: 라운드, 브릿지 길이가 같으면 (다리 길이는 model 속 -1 해준 값을 bridge에게 전달함 ->
            통과 실패가 없다면 -> 종료*/
        if (round == bridge.size) {
            /*실패가 없다면 - > quit*/
        }
    }

}
