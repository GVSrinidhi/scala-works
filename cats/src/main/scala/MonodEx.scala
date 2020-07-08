import cats.Monad
import cats.instances.option._
import cats.instances.list._

object MonodEx extends App{


  def parseInt(str: String): Option[Int] =
    scala.util.Try(str.toInt).toOption

  def division(x: Int, y: Int): Option[Int] =
    if(y == 0) None
    else Some(x / y)

  //here at each step flat map chooses whether to call the f'n
  def stringdivision(s1:String,s2:String):Option[Int] =
    parseInt(s1).flatMap { n1 =>
      parseInt(s2).flatMap { n2 =>
        division(n1,n2)
      }
    }

  //for-comprehension
  def stringdivision1(s1:String,s2:String):Option[Int] =
    for{
      n1 <- parseInt(s1)
      n2 <- parseInt(s2)
      result <- division(n1,n2)
    }yield result

  println(stringdivision("10","0"))
  println(stringdivision("20","3"))
  println(stringdivision("20","s"))
  println(stringdivision1("20","2"))

  def listgen =
  for {
    x <- (1 to 3).toList
    y <- (4 to 5).toList
  } yield (x, y)

  println(listgen)


  val v1 = Monad[Option].pure(10)
  println(v1)
  val v2 = Monad[Option].flatMap(v1)(x=>Some(x*2))
  println(v2)
  val v3 = Monad[Option].map(v1)(x=>x/2)
  println(v3)

  val l1 = Monad[List].pure(3,4,5)
  println(l1)
  val l2 = Monad[List].flatMap(List(2,5,8))(x=>List(x,x+1))
  println(l2)

}
