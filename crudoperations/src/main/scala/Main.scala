import StudentRepoImpl.c1
import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.server.Router
import org.http4s.implicits._
import org.http4s.server.blaze._

object Main extends IOApp {

  private val studentRepo: StudentRepo = new c1

  val httpRoutes = Router[IO](
    "/" -> StudentRoutes.routes(studentRepo)
  ).orNotFound

  override def run(args: List[String]): IO[ExitCode] = {

    BlazeServerBuilder[IO]
      .bindHttp(3000, "0.0.0.0")
      .withHttpApp(httpRoutes)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
  }

}