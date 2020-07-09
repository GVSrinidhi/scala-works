import StudentDetails.StudentId
import cats.effect.IO
import scala.collection.mutable.HashMap

object StudentRepoImpl {

  class c1 extends  StudentRepo {

    val storage = HashMap[StudentId, Student]().empty

    override def addStudent(student: Student): IO[StudentId] = IO {
      val studentId = StudentId()
      storage.put(studentId, student)
      studentId
    }

    override def getStudent(id: StudentId): IO[Option[StudentWithId]] = IO {
      storage.get(id).map(student => StudentWithId(id.value, student.name, student.favsubject))
    }

    override def getStudents(): IO[List[StudentWithId]] = IO {
      storage.map {case (id, student) => StudentWithId(id.value, student.name, student.favsubject)}.toList
    }
  }
}
