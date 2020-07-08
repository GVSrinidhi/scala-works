import cats.Show
import cats.implicits._

object ShowEx extends App{

  case class Employee(name:String,empid:Int)

  implicit val emp : Show[Employee] = Show.show(employee => employee.name)

  println(emp)

  val nidhi = Employee("Srinidhi",1552)

  println(nidhi.show)

  println(show"Myself ${nidhi} and my id is ${nidhi.empid}")
  println(s"Myself ${nidhi.name} and my id is ${nidhi.empid}")

  val num : Show[Int] = Show.apply[Int]
  println(10.show)

  val str : Show[String] = Show.apply[String]
  println("Srinidhi".show)

}
