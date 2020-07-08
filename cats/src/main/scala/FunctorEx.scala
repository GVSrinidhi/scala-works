import cats.Functor
import cats.instances.option._
import cats.instances.list._


object FunctorEx extends App{

  val list1 = List(10,20,30)
  println(Functor[List].map(list1)(_%2))

  val option = Option(20d)
  println(Functor[Option].map(option)(_.toString))

  val options = List(Some(2),Some(4),Some(9))
  println(options.map(_.map(_+2)))

  //Instead of nested datatype we can use Functor compose method
  println(Functor[List].compose[Option].map(options)(_+2))

  val list = List(1,2,3,4,5)
  println(Functor[List].map(list)(_+2))


}