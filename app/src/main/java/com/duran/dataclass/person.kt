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

    override fun equals(other: Any?): Boolean {
        // 비교대상이 되는 instance를 받아서 null이거나 Person클래스가 아닐 경우에는 false를 반환하지만
        // instance property가 일치할 경우 동일한 객체라는 true판정을 받게된다.
        if(other == null || other !is Person) return false
        return name == other.name && age == other.age && sex == other.sex
    }
}

fun main() {
    val person1 = Person("Alice", 20, "female")
    // println(person1) // -> com.duran.dataclass.Person@71be98f5
    // 클래스에 toString을 override을 해주게되면 랜덤한 값이 아니라 클래스가 가진 property를 보여준다.
    println(person1) // -> Person(name=Alice, age=20, sex=female)

    // equal는 같은 클래스로부터 인스턴스를 만들었을때 클래스 내부 property가 동일하면 같은 인스턴스로 취급할지 판단하는 메서드
    val person2 = Person("Bob", 22, "Male")
    val person3 = Person("Bob", 22, "Male")
    // 내용이 동일함에도 불구하고 두 인스턴스가 같지않다는 판정이 나오게된다.
    // 위에서 equals를 override해주게되면 true로 바뀐다.
    println(person2 == person3) // false -> true
}
