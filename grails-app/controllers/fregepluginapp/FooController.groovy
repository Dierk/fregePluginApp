package fregepluginapp

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
}