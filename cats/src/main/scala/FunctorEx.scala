import cats.Functor
import cats.instances.option._
import cats.instances.list._


object FunctorEx extends App{

  val list1 = List(10,20,30)
  println(Functor[List].map(list1)(_%2))

  println(Option(5).map(_/2))
  println(List(2,4,6).map(_/2))

  val value = Option(20d)
  println(Functor[Option].map(value)(_.toString))

  val list2 = List(Some(2),Some(4),Some(9))
  println(list2.map(_.map(_+2)))

  //Instead of nested datatype we can use Functor compose method
  println(Functor[List].compose[Option].map(list2)(_+2))

}