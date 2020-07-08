object Map extends App {

  val list = List("Nidhi","Sri","Nithin")
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1 )) //map
  println(list.map(_ + " Is a string"))

  val list1 = List(1,2,3,4,5)

  println(list1.filter(_% 2!=0)) //filter

    //flat map
  val pair  = (a:Int) => List(a,a-1)

  println(list1.flatMap(pair))

  val chars = List('a','b','c')
  val nums = List(1,2,3)
  val str = List("Sri","Nidhi")

  //Replacing loops(Iterations)
  val combi = nums.flatMap(n => chars.map(c => "" + c + n))
  val comb = chars.flatMap(c => nums.map(n => "" + c + n))

  val combinations  = nums.flatMap(n => chars.flatMap(c => str.map( s => "" + c + n + " : " + s)))

  println(combi)
  println(comb)
  println(combinations)

  //for- comprehensions (More readable)
  val combinations1 = for {
    n <- nums
    c <- chars
    s <- str
  } yield "" + c + n + " : " + s

  println(combinations1)

  val filtercomb = for {
    n <- nums if n%2!=0
    c <- chars if c=='a'||c=='b'
    s <- str if s=="Nidhi"
  }yield "" + c + n + " : " + s

  println(filtercomb)

  //for each
  nums.foreach(println)

}