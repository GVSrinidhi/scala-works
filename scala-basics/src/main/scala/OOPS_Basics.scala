
object OOPS_Basics extends App {

  val emp = new Employee("Nidhi",22)
  println(emp.name)
  println(emp.company)
  println(emp.intro("Nithin"))
  println(emp.intro())

  val writer = new Writer("Chetan","Bhagat",1985)
  val novel = new Novel("3 Idiots",2010,writer)


  println(novel.ageofwriter)
  println(novel.writtenby(writer))


}

class Employee(val name:String,id:Int) {
  val company = "PS"

  def intro(name:String):Unit = println(s"$name and ${this.name} are Collaegues")

  def intro() : Unit = println(s"$name =  ${this.name}")

  //Auxilary constructor(same like def par) ==> calls another constructor
  def this(name:String) = this(name,0)


}

class Writer(fname:String,lname:String,val year:Int){

  def fullname():String = s"$fname $lname"

}

class Novel(name:String,year:Int,author:Writer){

  def ageofwriter = year-author.year
  def writtenby(author:Writer) = author==this.author
  def copy(newyear:Int):Novel = new Novel(name,newyear,author)

}


