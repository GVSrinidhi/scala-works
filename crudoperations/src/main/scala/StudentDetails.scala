import StudentDetails.{FavSubject, Id, Name}

import scala.util.Random

object StudentDetails {

  type Id = String
  type Name = String
  type FavSubject = String
  final case class StudentId(value:String = Random.alphanumeric.take(8).foldLeft("")((result, c) => result + c))

}

case class Student(name: Name, favsubject: FavSubject)
case class StudentWithId(id: Id, name: Name, favsubject: FavSubject)
