object Functions extends App {

  //called by value , function calls happens at beginning

  def byvalue(time:Long): Unit = {
    println("Called by value :"+time)
    println("Called by value :"+time)
  }

  // Here in called by name , fn call happens each and every time
  def byname(time : => Long): Unit ={
    println("Called by value :"+time)
    println("Called by value :"+time)

  }

  byvalue(System.nanoTime())
  byname(System.nanoTime())

  def fun(name:String="sri",age:Int,height:Int=6):Unit=
    println("Name: "+name+" Age: "+age+" Height: "+height)

  fun("nidhi",22)
  fun(age = 22)

  val add = new Function2[Int,Int,Int] {
    override def apply(x:Int,y:Int)=x+y
  }

  val sub :(Int,Int) => Int = new Function2[Int,Int,Int] {
    override def apply(a:Int,b:Int)=a-b
  }

  println(add(5,6))
  println(sub(10,5))

  def concat : (String,String) => String = new Function2[String,String,String] {
    override def apply(str1:String,str2:String):String = str1 + str2
  }

  println(concat("sri","nidhi"))

  val multi : Function1[Int,Function1[Int,Int]] =new Function1[Int,Function1[Int,Int]]{
    override def apply(v1 : Int) :Function1[Int,Int] = new Function1[Int,Int] {
      override def apply(v2 : Int) : Int = v1*v2
    }
  }

  val imp = multi(3)
  println(imp(5))
  //Curried f'n
  println(multi(10)(3))



}
