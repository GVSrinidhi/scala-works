import cats.Monad
import cats.instances.option._
import cats.syntax.apply._
import cats.syntax.flatMap._
import cats.syntax.functor._

object SemigroupalEx2 extends App {

  val multiply : (Int,Int) => Int = (a,b) => a*b
  println((Option(2),Option(6)).mapN(multiply))

  val calc : (Int,Int,Int) => Int = (a,b,c) => a+b*c
  println((Option(2),Option(3),Option(4)).mapN(calc))

  //product in terms of map and flatMap
  def product[M[_] : Monad , A , B](x:M[A],y:M[B]):M[(A,B)] =
    x.flatMap(a => y.map(b => (a,b)))

   //Same as for-comprehension
   def product1[M[_]: Monad, A, B](x: M[A], y: M[B]): M[(A, B)] =
     for {
       a <- x
       b <- y
     } yield (a, b)

}
