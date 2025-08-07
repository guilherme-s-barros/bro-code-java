package io.github.guilherme_s_barros.anonymous_class;

public class Program {
    public static void main(String[] args) {
        var dog = new Dog();

        dog.speak();

        var scoobyDoo = new Dog() {
            @Override
            void speak() {
                System.out.println("Scooby says: Scooby doob doo!");
            }
        };

        scoobyDoo.speak();

        var thing = new Object() {
            void doSomething() {
                System.out.println("Thing do something.");
            }
        };

        thing.doSomething();
    }
}
