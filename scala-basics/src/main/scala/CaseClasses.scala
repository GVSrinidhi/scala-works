object CaseClasses extends App{

  case class Employee(name:String,id:Int)


  val emp1 = new Employee("Nidhi",11)
  val emp2 = new Employee("Nidhi",11)

  println(emp1.name)

  println(emp1)
  println(emp1.toString)

  println(emp1==emp2)

  val emp3 = emp1.copy(id=22)

  println(emp3)

  val emp4 = Employee("Nithin",33) //No need of new
  println(emp4)

  case object Student {
    def name : String = "Srinidhi"

  }


}
