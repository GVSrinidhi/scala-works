object Exceptions extends App{


  val num :String= null
//  println(num.length)

  def getstring(bool : Boolean):String =
    if(bool) throw new RuntimeException("Exception")
    else "Nidhi"

  try{
    getstring(false)
  } catch{
    case ex:RuntimeException => println("It's RuntimeException")
  } finally{
    println("Block that happens for sure!")
  }

  class OverflowException extends Exception
  class UnderflowException extends Exception
  class CalculationException extends Exception

  object Calc {
    def addition(val1:Int,val2:Int) = {
      val res =val1+val2
      if(val1>0&&val2>0&&res<0) throw new OverflowException
      if(val1<0&&val2<0&&res>0) throw new UnderflowException
      res
    }

    def division(val1:Int,val2:Int) = {
      if(val2==0) throw new CalculationException
      else val1/val2
    }
  }

  println(Calc.addition(Int.MaxValue,1))
  println(Calc.division(100,0))



}
