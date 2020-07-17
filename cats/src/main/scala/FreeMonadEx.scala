

object UserInteraction {
  sealed trait  UserInteraction[A]
  case class Tell(statement:String) extends UserInteraction[Unit]
  case class Ask(question:String) extends UserInteraction[String]
}

object InteractionDsl {
  import UserInteraction._
  import cats.free.Free
  type InteractionDsl[A] = Free[UserInteraction,A]

  //using liftF to map our case classes to our instances as free
  def tell(statement:String):InteractionDsl[Unit] = Free.liftF[UserInteraction,Unit](Tell(statement))
  def ask(question:String):InteractionDsl[String] = Free.liftF[UserInteraction,String](Ask(question))

}

object UserInterpreter {
  import UserInteraction._
  import cats.{~>,Id}

  def interpreter : UserInteraction ~> Id = new (UserInteraction ~> Id) {
     def apply[A](userInteraction : UserInteraction[A]): Id[A] = userInteraction match {
       case Tell(statement) =>
         println(statement)
         ()
       case Ask(question) =>
         println(question)
         val answer = scala.io.StdIn.readLine()
         answer
     }
  }
}

object UserProgram {
  import  InteractionDsl._
  import UserInterpreter._
  import cats.Id

  val program = for {
    _ <- tell("Hello welcome!!")
    name <- ask("Your name pls?")
    age <- ask(s"Hi $name. How old are you?")
    _ <- tell(s"You name $name and age $age is added into db!")
  } yield ()

  def run() : Id[Unit] = program foldMap interpreter


}

object FreeMonadEx extends App(){
  UserProgram.run()
}
