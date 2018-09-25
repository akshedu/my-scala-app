// Calculates absolute value of the input

package AbsPackage

object MyModule {
	def abs(n: Int): Int = {
		if (n < 0) -n
		else n
	}

	def factorial(n: Int): Int = {
		def loop(n: Int, acc: Int): Int = {
			if (n <= 1) acc
			else loop(n-1, n*acc)
		}
		loop(n, 1)
	}

	def fib(n: Int): Int = {
		def loop(n: Int, current: Int, prev: Int): Int = {
			if (n <= 2) current
			else loop(n - 1, prev + current, current)
		}
		if (n == 1) 0
		else if (n == 2) 1
		else loop(n, 1, 0)
	}

	private def formatAbs(n: Int): String = {
		val msg = "The absolute value of %d is %d"
		msg.format(n, abs(n))
	}

	def main(args: Array[String]): Unit = {
		println(formatAbs(args(0).toInt))
	}
}