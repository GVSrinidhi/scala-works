import cats.Semigroupal
import cats.instances.option._
import cats.syntax.apply._

object SemigroupalEx2 extends App {

  val multiply : (Int,Int) => Int = (a,b) => a*b
  println((Option(2),Option(6)).mapN(multiply))

  val calc : (Int,Int,Int) => Int = (a,b,c) => a+b*c
  println((Option(2),Option(3),Option(4)).mapN(calc))


}
