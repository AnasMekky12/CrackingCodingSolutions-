package StacksAndQueues;

import java.util.LinkedList;

public class Q6 {

    public static void main(String[] args) {
        AnimalQueue shelter = new AnimalQueue();

        shelter.enqueue(new Dog("Dog1"));
        shelter.enqueue(new Cat("Cat1"));
        shelter.enqueue(new Dog("Dog2"));
        shelter.enqueue(new Cat("Cat2"));

        System.out.println("After enqueue:");
        shelter.printQueues();

        System.out.println("\nDequeueAny: " + shelter.dequeueAny().getName());

        System.out.println("DequeueCat: " + shelter.dequeueCats().getName());

        System.out.println("DequeueDog: " + shelter.dequeueDogs().getName());

        System.out.println("\nAfter dequeues:");
        shelter.printQueues();
    }
}

abstract class Animal {
    private int order; 
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class AnimalQueue {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; 

    public void enqueue(Animal animal) {
        animal.setOrder(order); 
        order++;

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCats();
        } else if (cats.isEmpty()) {
            return dequeueDogs();
        }

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();

        if (oldestDog.isOlderThan(oldestCat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll(); 
    }

    public void printQueues() {
        System.out.println("Dogs Queue:");
        for (Dog dog : dogs) {
            System.out.println("- " + dog.getName() + " (Order: " + dog.getOrder() + ")");
        }

        System.out.println("Cats Queue:");
        for (Cat cat : cats) {
            System.out.println("- " + cat.getName() + " (Order: " + cat.getOrder() + ")");
        }
    }
}
