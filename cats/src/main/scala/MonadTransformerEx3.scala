import scala.concurrent.Future
import cats.data.{EitherT, OptionT}
import cats.instances.future._
import scala.concurrent.ExecutionContext.Implicits.global
import cats.syntax.applicative._

object MonadTransformerEx3 extends App{

  //Future of an Either of Option

  type FutureEither[A] = EitherT[Future,String,A]
  
  // String is error type for Either
  //A is result type for Either

  type FutureEitherOption[A] = OptionT[FutureEither,A]

  val val1 : FutureEitherOption[Int] =
    for {
      x <- 15.pure[FutureEitherOption]
      y <- 5.pure[FutureEitherOption]
    } yield x/y

  println(val1)

}

