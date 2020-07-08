import cats.Monad
import cats.syntax.functor._
import cats.syntax.flatMap._
import cats.instances.option._
import cats.instances.list._
import cats.Id

object MonodEx1 extends App{

  def sumSq[F[_]: Monad](a:F[Int],b:F[Int]):F[Int] =
    a.flatMap(x=>b.map(y => x*x + y*y))

  println(sumSq(Option(2),Option(3)))
  println(sumSq(List(1,2),List(3,4)))

  //using for-comprehension

  def sumSq1[F[_]:Monad](a:F[Int],b:F[Int]):F[Int] =
    for{
      x <- a
      y <- b
    }yield x*x + y*y

  println(sumSq1(Option(2),Option(3)))
  println(sumSq1(List(1,2),List(3,4)))

  //can't use int directly as param bcz argument expressions type is
  // not compatible with formal parameter. Use Id ==> Id[A] = A

  println(sumSq(3:Id[Int],3:Id[Int]))

}
