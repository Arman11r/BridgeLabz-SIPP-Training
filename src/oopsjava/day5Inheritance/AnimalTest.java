package oopsjava.day5Inheritance;

class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Tweet Tweet!");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Bruno", 3),
            new Cat("Whiskers", 2),
            new Bird("Tweety", 1)
        };

        for (Animal a : animals) {
            a.makeSound(); 
        }
    }
}