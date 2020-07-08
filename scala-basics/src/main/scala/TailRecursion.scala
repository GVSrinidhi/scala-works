import scala.annotation.tailrec

object TailRecursion extends App{

  @tailrec
  def fact(n:Int,accum:BigInt):BigInt=
    if(n<=1) accum
    else fact(n-1,n*accum)

  println(fact(50,1))

  def fib(n:Int):Int={
    def fib1(i:Int,last:Int,lastbutone:Int):Int=
      if (i>=n) last
      else fib1(i+1,last+lastbutone,last)

    if(n<=2) 1
    else fib1(3,1,1)

  }

  println(fib(10))
}
