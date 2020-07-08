object Strings extends App {

  //string interpolators (s,f&raw)

  val name="Nidhi"
  val age = 22
  val greeting = s"My name is $name and i'm $age years old and next year i'll be ${age+1} years old"
  println(greeting)

  val speed = 2.5f
  val running = f"$name can run $speed%2.3f km per hour"
  println(running)

  val line="this has \t\tdouble space"
  println(raw"this has \t\tdouble space")
  println(raw"$line")

}
