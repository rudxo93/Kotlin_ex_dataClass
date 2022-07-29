package com.duran.dataclass



// 코틀린에서 클래스를 만들때는 java language 스펙이 따라서 toString, equal, hashCode라는 메서드를 구현해야한다.
/*class Person (
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

    // 같은 속성을 가진 객체가 동일한 hash값을 갖기 때문에 동일한 객체 true
    override fun hashCode(): Int {
        return (name.hashCode() * 31 + age - sex.hashCode()) * 31
    }
}*/

// BUT! 그냥 property만을 가지는 단순한 클래스일 경우에는 toString, equals, hashCode 다 정의해주는 것이
// 번거로운 일이기때문에 코틀린에서는 DataClass라는 새로운 클래스가 있다.
// DataClass를 사용하면 위에서 언급한 toString, equals, hashCode 메서드를 다 자동으로 정의해주기 때문에
// 간단하게 클래스를 만들 수 있다.
// DataClass사용하는 방법은 간단하다.
// 클래스 앞에 data라는 접두어를 붙혀주기만 하면 된다.
data class Person (var name: String, var age: Int, var sex: String)

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

    // hashCode는 instance의 hash값을 정의하는 메서드이다.
    // 이 부분을 정의하지 않으면 equals값이 동일하더라도 서로 다른 객체가 되버린다.
    val personSet = hashSetOf(Person("Alice", 20, "Female"))
    println(personSet.contains(Person("Alice", 20, "Female"))) // false -> true

    // DataClass에는 CopyMethod도 있다.
    // copy는 이미 존재하는 instance의 파라미터만을 바꿔서 사용할 객체를 만들어주는 메서드
    // 이때 복사는 얕은 복사로 이루어진다.
    // Person("Bob", 22, "Male")을 복사해서 name만 Alice로 바꾼다.
    val person4 = Person("Bob", 22, "Male")
    val person5 = person4.copy(name = "Alice")
    println(person5) // Person(name=Alice, age=22, sex=Male)

    // DataClass에는 destructuring declarations이 있다.
    // DataClass는 객체가 소유한 데이터를 쪼개주는 기능을 제공
    val person6 = Person("Alice", 24, "Female")
    val (name, age, sex) = person6
    println("$name, $age years old $sex") // Alice, 24 years old Female
}
