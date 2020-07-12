import cats.Monoid
import cats.instances.int._
import cats.instances.invariant._
import cats.instances.list._
import cats.instances.string._
import cats.syntax.apply._
import cats.syntax.semigroup._

object SemigroupalEx3 extends App{

  final case class Student(name:String,age:Int,favsubjects:List[String])

  val tupleToStudent :  (String,Int,List[String]) => Student = Student.apply _

  val studentToTuple : Student => (String,Int,List[String]) =
    Student => (Student.name,Student.age,Student.favsubjects)

  implicit val studentMonoid : Monoid[Student] = (
    Monoid[String],
    Monoid[Int],
    Monoid[List[String]]
  ).imapN(tupleToStudent)(studentToTuple)

  val nidhi = Student("Srinidhi",21,List("DBMS","Java","Scala"))
  val nithin = Student("Nithin",21,List("Science","Social"))
  println(nidhi |+| nithin)
  
}
