import scala.language.postfixOps
object Notations extends App {

  class Student(val name:String,favsport:String) {
    def likes(sport:String):Boolean = sport==favsport
    def friend(student:Student):String = s"${this.name} is friend of ${student.name}"
    def unary_! : String = s"$name , This is called prefix notation!!"
    def isPlaying : Boolean = true
    def apply() : String = s"Myself $name "
  }

  val nidhi = new Student("Nidhi","Hockey")
  println(nidhi.likes("Hockey"))

  // Infix/operator notation ==> methods with 1 parameter
  println(nidhi likes "Hockey")
  val nithin =  new Student("Nithin","Badminton")
  println(nidhi friend nithin)

  //prefix notation ==> unary operators(- + ~ !)
  println(!nidhi)
  println(nidhi.unary_!)

  //postfix notation ==> methods that has no parameters
  println(nidhi.isPlaying)
  println(nidhi isPlaying)

  //apply
  println(nidhi.apply())
  println(nidhi())


}
