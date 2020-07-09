import cats.Semigroupal
import cats.instances.option._
import cats.syntax.apply._
import cats.instances.future._
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import cats.instances.list._

import scala.concurrent.Future

object SemigroupalEx1 extends App{

  //Both param as option ie.,Some then res =>tuple of values
  println(Semigroupal[Option].product(Some(33),Some("nidhi")))

  //Anyone is None then result is None
  println(Semigroupal[Option].product(None,Some(12)))

  val val1 = Semigroupal[Future].product(Future("33"),Future("Srinidhi"))
  println(Await.result(val1,2.second))

  println(Semigroupal[List].product(List(1,3,5),List(2,4,6)))

  //> 3 contexts
  println(Semigroupal.tuple3(Option(2),Option(4),Option(10)))
  println(Semigroupal.tuple3(Option.empty[Int],Option(4),Option(10)))

  //map 2..2 => customized
  println(Semigroupal.map2(Option(12),Option(3))(_/_))
  println(Semigroupal.map3(Option(2),Option(4),Option.empty[Int])(_+_+_))

  //tupled method is added to tuple of Options(2..22)
  println((Option(2),Option(4),Option(10)).tupled)
  println((Option(2),Option(4),Option(10),Option.empty).tupled)


}
