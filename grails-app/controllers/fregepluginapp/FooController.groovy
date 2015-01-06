package fregepluginapp

class FooController {
	static scope = "session"

	def computerBegins = true // computer begins

	def ttt() {
//		println params
		def result = [0] * 9
		def gameover = false
		def board = params.board
		int lookahead = params.lookahead != null ? params.lookahead.toInteger() : 3
		if (board) {
			board = Eval.me(board) // quick&dirty String to list conversion. Not for production!
			if (params.new != null) board[params.new.toInteger()] = -1 // human has placed mark (O)
			def calculated  = Minimax.nextBoard(lookahead, board as int[])
			if (calculated) {
				result = calculated
			} else {
				gameover = true
			}
		} else {
			if (computerBegins){
				int randomStartPos = Math.random() * 8
				result[randomStartPos] = 1 // first mark in the game randomly by computer (X)
			}
			computerBegins = ! computerBegins // toggle who begins next
		}
		render view:'edit', model: [board: result, boardStr: result.toString(), gameover:gameover, lookahead:lookahead]
	}
}