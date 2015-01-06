package fregepluginapp

class FooController {
    static scope = "session"

    def computerBegins = true // computer begins
    int[] board = [0] * 9

    def ttt() {
//		println params
        def gameover = false
        int lookahead = params.lookahead != null ? params.lookahead.toInteger() : 3

        if (params.newGame){
            board = [0] * 9
            if (computerBegins) {
                int randomStartPos = Math.random() * 8
                board[randomStartPos] = 1 // first mark in the game randomly by computer (X)
            }
            computerBegins = !computerBegins // toggle who begins next
        } else {
            if (params.index != null) {
                board[params.index.toInteger()] = -1            // human has placed mark (O)
                def calculated = Minimax.nextBoard(lookahead, board)
                if (calculated) {
                    board = calculated
                } else {
                    gameover = true
                }
            }
        }

        render view: 'edit', model: [board: board, gameover: gameover, lookahead: lookahead]
    }
}