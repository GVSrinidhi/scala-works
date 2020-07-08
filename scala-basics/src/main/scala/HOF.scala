object HOF extends App{

  def hof(f:Int=>Int,n:Int,x:Int):Int =
    if(n<=0) x
    else hof(f,n-1,f(x))

  val f = (x:Int) => x+1

  println(hof(f,3,5))

  val sub = (x:Int) => (y:Int) => x-y
  println(sub(10)(5))

  val btw = sub(5)
  println(btw(10))

  //Currying ==> multiple param

  def strcat(str1:String)(str2:String) = str1+str2

  println(strcat("Sri")("nidhi"))



}
