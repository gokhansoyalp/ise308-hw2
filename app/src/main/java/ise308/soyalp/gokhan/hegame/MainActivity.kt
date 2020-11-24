package ise308.soyalp.gokhan.hegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

open class Vehicle (carryPassenger: Boolean, tyres: Int, fuelCapacity: Int) : Parcelable {
    init {
        public val println: Any = println("Vehicle carry passenger: $carryPassenger")
        public val println1: Any = println("Tyres in Vehicle: $tyres")
        public val println2: Any = println("Capacity of Vehicle(Fuel): $fuelCapacity")
    }
    open val color: String = "White"

    constructor(parcel: Parcel) : this(
            TODO("carryPassenger"),
            TODO("tyres"),
            TODO("fuelCapacity")) {
    }

    open fun vehicleColor(){
        println("Vehicle color is: $color")
    }

    open fun start(){
        println("Vehicle Running")
    }

    open fun driver(name: String){
        println("Vehicle is driven by: $name")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vehicle> {
        override fun createFromParcel(parcel: Parcel): Vehicle {
            return Vehicle(parcel)
        }

        override fun newArray(size: Int): Array<Vehicle?> {
            return arrayOfNulls(size)
        }
    }

}

class Car (carryPassenger: Boolean, tyres: Int, fuelCapacity: Int, airBags: Int) : Vehicle (carryPassenger, tyres, fuelCapacity) {
    init {
        println("Number of air bags in car: $airBags")
    }

    override fun start() {
        println("Driving a Car")
    }

    override fun driver(name: String) {
        println("Car is driven by $name")
    }

    override val color: String = "Blue"
    override fun vehicleColor() {
        println("Car Color is: $color")

    }
}

    // child class
    class Truck : Vehicle {
        constructor(carryPassenger: Boolean, tyres: Int, fuelCapacity: Int, lcCapacity: Int) : super(carryPassenger, tyres, fuelCapacity) {
            println("Load carrying capacity is: $lcCapacity")
        }
        override fun start() {
            println("Driving a Truck")
        }

        override fun driver(name: String) {
            println("Truck is driven by $name")
        }

        override val color: String = "Purple"
        override fun vehicleColor() {
            println("Truck Color is: $color")

        }
    }

    fun main() {
        val truck = Truck(false, 10, 200, 1000)
        val car: Car = Car(true, 4, 50, 4)

        car.start()
        car.driver("Gökhan")
        car.vehicleColor()
    }