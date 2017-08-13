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


