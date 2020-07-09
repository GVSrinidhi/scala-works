import cats.instances.either._
import cats.syntax.applicative._
import cats.data.OptionT

object MonadTransformerEx2 extends App{

  type ErrorOr[A] = Either[String,A]
  type ErrorOrOption[A] = OptionT[ErrorOr,A]

  val val1 = 30.pure[ErrorOrOption]
  val val2 = 10.pure[ErrorOrOption]

  println(val1.flatMap(a => val2.map(b => a/b)))

}
