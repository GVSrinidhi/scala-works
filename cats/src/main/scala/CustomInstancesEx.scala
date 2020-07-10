import java.util.Date

import cats.Show

object CustomInstancesEx extends App {

  implicit val showDate: Show[Date] =
    Show.show(date => s"${date.getTime}ms and $date since the epoch")

  println(showDate.show(new Date()))

}
