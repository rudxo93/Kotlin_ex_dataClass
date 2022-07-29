package com.duran.dataclass

// 코틀린에서 클래스를 만들때는 java language 스펙이 따라서 toString, equal, hashCode라는 메서드를 구현해야한다.
class Person (
    var name: String,
    var age: Int,
    var sex: String
    )

fun main() {
    val person1 = Person("Alice", 20, "female")
    println(person1) // -> com.duran.dataclass.Person@71be98f5
}