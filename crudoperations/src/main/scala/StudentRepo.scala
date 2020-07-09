import StudentDetails.StudentId
import cats.effect.IO

trait StudentRepo {

  def addStudent(student: Student): IO[StudentId]
  def getStudent(id: StudentId): IO[Option[StudentWithId]]
  def getStudents(): IO[List[StudentWithId]]
}

