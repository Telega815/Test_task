package ru.test_task.tasks;

import java.util.ArrayList;

/**
 * @autor telega815
 * @date 13.09.2017
 */

public class Test{

	public static void main(String[] args){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Cat("Mary", 1));
		animals.add(new Dog("Max", 2));
		animals.add(new CatDog("Moe", 3));
		for(Animal animal : animals){
			System.out.println(animal.makeSound());
			System.out.println(animal.beUsefull());
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println();

		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(new Client("John", "Cat", "Jarry", 1));
		clients.get(0).addAnimal(animals.get(0));

		clients.add(new Client("Jane", "Dog", "Lacy", 1));
		clients.get(1).addAnimal(animals.get(1));

		for(Client client : clients){
			System.out.println(client.findAnimal("Mary").getName());
			System.out.println(client.findAnimal("Jux").getName());
			System.out.println(client.findAnimal("Lacy").getName());
			System.out.println();
			System.out.println();
		}
	}
}