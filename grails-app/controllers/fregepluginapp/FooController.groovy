package fregepluginapp

import frege.runtime.Delayed

import static com.canoo.FregeCaller.perform
import fregepluginapp.FregeCode

class FooController {

    def index() {
		// calling some put Frege code with primitives or an array thereof is just like any Java call
		int product = FregeCode.multiply(5,3)
		int total   = FregeCode.total([1,2,3] as int[])

		def foo = new Foo(firstname: 'single')

		// calling Frege code that is modifying domain classes returns an action that must be performed
		perform(FregeCode.twiceFirstname(foo))

		render text: """<pre>
			5 * 3 is $product
			and the total of [1,2,3] is $total
			and the doubled Foo first name is $foo.firstname
"""
	}

	def ttt() {
//		println params
		def result = [0] * 9
		def gameover = false
		def board = params.board
		int lookahead = params.lookahead?.toInteger() ?: 0
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
			int randomStartPos = Math.random() * 8
			result[randomStartPos] = 1 // first mark in the game randomly by computer (X)
		}
		render view:'edit', model: [board: result, boardStr: result.toString(), gameover:gameover, lookahead:lookahead]
	}
}