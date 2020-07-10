object Math{

  //3 type class components
  //type class
  trait NumberLike[A] {
    def add(a: A, b: A): A
    def mul(a: A, b: A): A
  }

  //instances
  implicit val intLike: NumberLike[Int] = new NumberLike[Int] {
    override def add(a: Int, b: Int): Int = a + b
    override def mul(a: Int, b: Int): Int = a * b
  }

}
object TypeClassEx extends App {
  import Math.NumberLike
  //type class interface
  def addition[A](a:A,b:A)(implicit ev : NumberLike[A]) =
    ev.add(a,b)
  println(TypeClassEx.addition(3,4))
}

