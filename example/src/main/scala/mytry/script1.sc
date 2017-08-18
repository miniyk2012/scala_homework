def square(x: Double) = x * x
def sumofsquare(x:Double, y:Double) = square(x) + square(y)

square(5)
sumofsquare(10,5)

sumofsquare(3, 2+2)

def loop: Int = loop

//loop
def x = loop


def first(x:Int, y: Int) = x
//first(1, loop)  // 默认是call-by-value

def constOne(x: Int, y: => Int) = 1
constOne(1+2, loop)  // y是call-by-name
//constOne(loop, 1)  // loop会无限reduce下去，从而无法终止


// 练习2.1
//def fib(n: Int): Int = {
//  var a = 0
//  var b = 1
//  var i = 0
//  while (i < n) {
//    val prev_a = a
//    a = b
//    b = prev_a + b
//    i = i + 1
//  }
//  a
//}
//You can often rewrite code that uses mutable
// local variables to code with
// helper functions that take accumulators
def fib(n: Int): Int = {
  def go(i: Int, acc1: Int, acc2: Int): Int = {
    if (i==n) acc1
    else go(i+1, acc2, acc1+acc2)
  }
  go(0, 0, 1)
}

fib(0)
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

def and(x:Boolean,y:Boolean): Boolean =
  if (x) {
    if (y)
      true
    else false
    }
  else
    false

and(true, true)
and(false, true)
and(false, false)
and(true, false)

def and1(x:Boolean,y: =>Boolean) = if (x) y else false
def loop1: Boolean = loop1


and1(true, true)
and1(false, true)
and1(false, false)
and1(true, false)
and1(false, loop1)

def or(x:Boolean,y: => Boolean) = if (x) true else y

or(true, true)
or(false, true)
or(false, false)
or(true, false)
or(true, loop1)


