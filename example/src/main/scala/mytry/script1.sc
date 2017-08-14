def square(x: Double) = x * x
def sumofsquare(x:Double, y:Double) = square(x) + square(y)

square(5)
sumofsquare(10,5)

sumofsquare(3, 2+2)

def loop: Int = loop

//loop

def first(x:Int, y: Int) = x
//first(1, loop)  // 默认是call-by-value

def constOne(x: Int, y: => Int) = 1
constOne(1+2, loop)  // y是call-by-name
//constOne(loop, 1)  // loop会无限reduce下去，从而无法终止


// 练习2.1
def fib(n: Int): Int = {
  def go(n: Int, acc1: Int, acc2: Int): Int = {
    if (n<2) acc1
    else go(n-1, acc2, acc1+acc2)
  }
  go(n, 0, 1)
}

fib(1)
fib(2)
fib(3)
fib(4)
fib(5)
fib(6)
fib(7)

// 练习2.2
def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
  def loop(n: Int, sorted: => Boolean): Boolean = {
    if (!sorted) false
    else if (n >= as.length-1) true
    else loop(n+1, ordered(as(n), as(n+1)))
  }
  loop(0, true)
}

isSorted(Array(1,0), (x: Int, y: Int) => x<=y)
isSorted(Array(1), (x: Int, y: Int) => x<=y)
isSorted(Array(1,2,3,4), (x: Int, y: Int) => x<=y)
isSorted(Array(), (x: Int, y: Int) => x<=y)
isSorted(Array(1,2,3,4,5,5), (x: Int, y: Int) => x<=y)
isSorted(Array(1,2,0,4,5,5), (x: Int, y: Int) => x<=y)


def partial1[A,B,C](a: A, f: (A,B)=>C): B => C =
  (b: B) => f(a,b)

// 练习2.3
def curry[A,B,C](f:(A,B) => C): A => (B=>C) =
  (a: A) => (b: B) => f(a, b)

// 练习2.4
def uncurry[A,B,C](f:A=>B=>C): (A,B)=>C =
  (a:A, b:B) => f(a)(b)

// 练习2.5
def compare[A,B,C](f:B=>C, g:A=>B): A=>C =
  (a:A) => f(g(a))
//  g andThen f
//  f compose g




