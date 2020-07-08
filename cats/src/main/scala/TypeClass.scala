import VehiclefeaturesInstances.carhasfeatures

sealed trait Vehicle
final case class Car(name : String) extends Vehicle

trait Vehiclefeatures[V]{
  def break(v:V): Unit
}

object VehiclefeaturesInstances {
  implicit val carhasfeatures = new Vehiclefeatures[Car] {
    override def break(car: Car): Unit = println(s"Car name is ${car.name} and it has a break")
  }
}

object Vehiclefeatures {

  def break[V](v: V)(implicit vehiclefeaturesInstances: Vehiclefeatures[V]): Unit = {
    vehiclefeaturesInstances.break(v)
  }
}

object TypeClass extends App{

  val bmw = Car("BMW")
  Vehiclefeatures.break(bmw)
}