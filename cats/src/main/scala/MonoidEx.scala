import cats.Monoid
import cats.Semigroup
import cats.instances.string._
import cats.instances.int._
import cats.instances.option._
import cats.syntax.semigroup._ // for |+|
import cats.instances.map._
import cats.instances.tuple._

object MonoidEx extends App{

  println(Monoid[String].combine("Sri","nidhi"))
  println(Monoid[Int].combine(10,20))
  println(Monoid[String].empty)
  println(Semigroup[String].combine("Srinidhi ","Gangula"))

  val x = Option(15)
  val y = Option(10)

  println(Monoid[Option[Int]].combine(x,y))

  val value = 1 |+| 2 |+| 3 |+| 4
  println(value)

  val string = "Myself " |+| "Srinidhi"
  println(string)

  println(Option(5) |+| Option(2))

  val m1 = Map("Sri"->1,"nidhi"->2)
  val m2 = Map("Nithin"->3,"GV"->4)

  println(m1 |+| m2)

  val t1 = ("Nidhi",20)
  val t2 = ("Nithin",22)

  println(t1 |+| t2)

  def addition[A:Monoid](values: List[A]) : A=
    values.foldRight(Monoid[A].empty)(_ |+| _)

  println(addition(List(10,15,20,25,30)))

}
