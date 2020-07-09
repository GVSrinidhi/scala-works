import cats.Semigroupal
import cats.data.Validated
import cats.instances.list._
import cats.syntax.validated._
import cats.syntax.applicative._
import cats.syntax.applicativeError._

object ValidatedEx extends App{

  type AllErrorsOr[A] = Validated[List[String],A]

  println(Semigroupal[AllErrorsOr].product(
    Validated.invalid(List("Error 1","Error 2")),
    Validated.invalid(List("Error 3"))
  ))

  //creating instances to validated
  //validated => 2 subtypes(Valid and invalid)
  val v = Validated.valid(List(2,5))
  println(v)
  val i = Validated.invalid(List("Sri","nidhi"))
  println(i)

  //using smart constructors
  val v1 = Validated.valid[List[String], Int](121)
  println(v1)
  val i1 = Validated.invalid[List[String], Int](List("Hello", "world"))
  println(i1)

  //using valid and invalid extension methods
  val v2 = 321.valid[List[String]]
  println(v2)
  val i2 = ("Nidhi").invalid[Int]
  println(i2)

  //using pure and raise error
  type ErrorsOr[A] = Validated[List[String], A]
  val v3 = 21.pure[ErrorsOr]
  println(v3)
  val i3 = List("Hello").raiseError[ErrorsOr,Int]
  println(i3)

  //helper methods from exceptions & try,Either,Option
  println(Validated.catchOnly[NumberFormatException]("world".toInt))
  println(Validated.catchNonFatal(sys.error("error found!!")))
  println(Validated.fromTry(scala.util.Try("Validated".toInt)))
  println(Validated.fromEither[String,Int](Left("Example")))
  println(Validated.fromOption[String,Int](None,"Sample"))

}
