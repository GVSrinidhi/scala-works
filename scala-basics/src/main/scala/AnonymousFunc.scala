object AnonymousFunc extends App{

  val mul1 = new Function2[Int,Int,Int] {
    override def apply(a:Int,b:Int) = a*b
  }

  val mul2 : (Int,Int) => Int = (x,y) => x*y
  val add = (a:Int,b:Int) => a+b

  println(mul1(5,6))
  println(mul2(5,6))
  println(add(5,5))

  val noparam : () => String = () => "Nidhi"
  println(noparam())

  val inttostr = { (value :Int) =>
    value.toString
  }

  println(inttostr(10))

  val div : (Int,Int) => Int = _ / _   // _ replaces the values.
  println(div(10,2))


  val adder = (a:Int) => (b:Int) =>a+b

  println(adder(5)(10))
}
