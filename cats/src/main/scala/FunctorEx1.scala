import cats.{Applicative, Functor}
import cats.instances.all._
import cats.syntax.functor._

object FunctorEx1 extends App{

  val f = (a:Int) => a*2
  println(Functor[List].lift(f))

  val lf= Functor[List].lift(f)
  println(lf(List(10,20)))

  def strlen(str:String):Int = str.length
  val fun=Functor[Option].lift(strlen)
  val s=Some("Srinidhi")
  println(fun(s))

  //Applicative

  println(Applicative[Option].ap(Some(strlen _))(s))

  val mod : (Int,Int) => Int = _ % _
  val x = List(20,33)
  val y = List(3,2)
  println(Applicative[List].map2(x,y)(mod))

  val f1 = (A:Int) => A+2
  val f2 = (A:Int) => A*2
  val f3 = (A:Int) => s"$A!"
  val flast= f1.map(f2).map(f3)

  println(flast(20))

  def fun[F[_]](start: F[Int])
  (implicit functor: Functor[F]): F[Int] = start.map(n=>n/2)

  println(fun(Option(20)))
  println(fun(List(11, 22, 33)))


  def fun1[F[_],x,y](start:F[x])(f:x=>y)
                    (implicit F : Functor[F]) : F[y] = F.map(start)(f)

  println(fun1(Option(20))(_/2))
  println(fun1(List(10,20,30))(_/2))

}
