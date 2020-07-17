import cats.free.Free
import cats.free.Free.liftF
import cats.arrow.FunctionK
import cats.{Id, ~>}
import scala.collection.mutable

object UI {

  sealed trait storeA[A]

  //Free[_] ==> used to create an embedded DSL

  //create ADT(Algebraic Data Type)
  case class Put[T](key: String, value: T) extends storeA[Unit]

  case class Get[T](key: String) extends storeA[Option[T]]

  case class Delete(key: String) extends storeA[Unit]

  //Free ADT

  //type based on Free[_] and storeA[_]
  type store[A] = Free[storeA, A]

  //smart constructors for store[_] using liftF(lift values from storeA[_] to store[_])
  def put[T](key: String, value: T): store[Unit] =
    liftF[storeA, Unit](Put[T](key, value))

  def get[T](key: String): store[Option[T]] =
    liftF[storeA, Option[T]](Get[T](key))

  def delete(key: String): store[Unit] =
    liftF(Delete(key))

  //update=>get+set
  def update[T](key: String, f: T => T): store[Unit] =
    for {
      x <- get[T](key)
      _ <- x.map(v => put[T](key, f(v))).getOrElse(Free.pure(()))
    } yield ()

  //Build a program out of key-value DSL operations

  def program: store[Option[Int]] =
    for {
      _ <- put("Nidhi", 5)
      _ <- update[Int]("Nidhi", (_ * 5))
      _ <- put("Sri", 3)
      n <- get[Int]("Nidhi")
      _ <- delete("Sri")
    } yield n

  //compiler
  def impureCompiler: storeA ~> Id =
    new (storeA ~> Id) {

      // a very simple (and imprecise) key-value store
      val st = mutable.Map.empty[String, Any]

      def apply[A](fa: storeA[A]): Id[A] =
        fa match {
          case Put(key, value) =>
            println(s"put($key, $value)")
            st(key) = value
            ()
          case Get(key) =>
            println(s"get($key)")
            st.get(key).map(_.asInstanceOf[A])
          case Delete(key) =>
            println(s"delete($key)")
            st.remove(key)
            ()
        }
    }

}
//Execute our compiled program.

object FreeMonadsEx1 extends App {
  import UI._

  val result: Option[Int] = program.foldMap(impureCompiler)
  println(result)

}
