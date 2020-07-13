import StudentDetails.StudentId
import cats.effect.IO
import io.circe.Json
import io.circe.generic.auto._
import org.http4s.circe.CirceEntityCodec._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

object StudentRoutes {

  def routes(studentRepo: StudentRepo): HttpRoutes[IO] = {

    val dsl = new Http4sDsl[IO]{}

    import dsl._

    HttpRoutes.of[IO] {

      case _ @ GET -> Root / "students" =>
        studentRepo.getStudents().flatMap(students => Ok(students))

      case req @ POST -> Root / "students" =>
        req.decode[Student] { student =>
          studentRepo.addStudent(student) flatMap(id =>
            Created(Json.obj(("id", Json.fromString(id.value))))
            )
        }

      case _ @ GET -> Root / "students" / id =>
        studentRepo.getStudent(StudentId(id)) flatMap {
          case None => NotFound()
          case Some(student) => Ok(student)
        }

    }
  }
}