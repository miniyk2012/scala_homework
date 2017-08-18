object session {
  1 + 2

  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)  // 最后一行是该函数的返回值
}
  sqrt(2)
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60)
  def sqrt_3 = sqrt(3)
  sqrt_3

  def sqrt_alt(x: Double) = sqrt(x)

  sqrt_alt(3)
}


session.sqrt(9)
val x = 1
def f(y: Int) = y+1
val result = {
  val x = f(3)
  x * x
} + x
x
val z=10; x+100

100
+100


(100
+100)

100 +
100

def factorial(n: Int) = {
  def go(n: Int, acc: Int): Int =
    if (n==0) acc
    else go(n-1, acc * n)

  go(n,1)
}
factorial(0)
factorial(1)
factorial(2)
factorial(3)
factorial(5)
factorial(10)

