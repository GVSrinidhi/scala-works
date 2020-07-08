object Recursion extends App {

  def fact (n : Int) : Int =
    if(n<=1) 1
    else n*fact(n-1)

  println(fact(5))

  def fib (n : Int) : Int =
    if(n<=2) 1
    else fib(n-1)+fib(n-2)

  println(fib(5))

}
