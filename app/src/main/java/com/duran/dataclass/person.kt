package com.duran.dataclass

// 코틀린에서 클래스를 만들때는 java language 스펙이 따라서 toString, equal, hashCode라는 메서드를 구현해야한다.
class Person (
    var name: String,
    var age: Int,
    var sex: String
    ) {
    // 클래스에 toString을 override
    override fun toString(): String {
        return "Person(name=$name, age=$age, sex=$sex)"
    }
}

fun main() {
    val person1 = Person("Alice", 20, "female")
    // println(person1) // -> com.duran.dataclass.Person@71be98f5
    // 클래스에 toString을 override을 해주게되면 랜덤한 값이 아니라 클래스가 가진 property를 보여준다.
    println(person1) // -> Person(name=Alice, age=20, sex=female)
}