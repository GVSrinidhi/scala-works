import cats.instances.list._
import cats.syntax.applicative._
import cats.data.OptionT

object MonadTransformerEx1 extends App{

  type ListOption[A] = OptionT[List,A]

  val val1 : ListOption[Int] = 15.pure[ListOption]
  val val2 : ListOption[Int] = OptionT(List(Option(20),Option(12)))

  println(val1.flatMap { (x: Int) =>
    val2.map { (y: Int) =>
      x + y
    }
  })

//OptionT(List(Some(52)))
}
