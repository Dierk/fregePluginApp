package fregepluginapp

import spock.lang.Specification

class MinimaxSpec extends Specification {

    void "board with one entry"() {
        given:
        int[] board = [-1, 0, 0,  0, 0, 0,  0, 0, 0]
        int[] blind = [-1, 0, 0,  0, 0, 0,  0, 0, 1]
        int[] smart = [-1, 0, 0,  0, 1, 0,  0, 0, 0]
        expect:
        blind == Minimax.nextBoard(1, board)
        blind == Minimax.nextBoard(4, board)
        smart == Minimax.nextBoard(5, board)
        smart == Minimax.nextBoard(8, board)
    }

    void "take immediate win regardless of lookahead"() {
        given:
        int[] board = [ 1, 1, 0, -1,-1, 0,  0, 0, 0]
        int[] smart = [ 1, 1, 1, -1,-1, 0,  0, 0, 0]
        expect:
        smart == Minimax.nextBoard(0, board)
    }

    void "lookahead sees loss coming, avoid unless we know it's unavoidable"() {
        given:
        int[] board   = [-1,-1, 0,  1, 0, 0,  1, 0, 0]
        int[] smart   = [-1,-1, 1,  1, 0, 0,  1, 0, 0]
        int[] blind   = [-1,-1, 0,  1, 0, 0,  1, 0, 1]
        int[] lost    = blind // no matter where to put the stone, the game is lost anyway
        expect:
        blind  == Minimax.nextBoard(0, board)
        smart  == Minimax.nextBoard(1, board)
        smart  == Minimax.nextBoard(2, board)
        lost   == Minimax.nextBoard(3, board)
        lost   == Minimax.nextBoard(8, board)
    }

}
