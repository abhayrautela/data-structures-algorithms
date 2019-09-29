package com.dsa.gayle.laakmann.chapter3.questions;

/*
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
 * at the shelter, or they can select whether they would prefer a dog or a cat (and will
 * receive the oldest animal of that type). They cannot select which specific animal they
 * would like. Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
 * use the built-in LinkedList data structure
 */
public class Problem7 {	
	
	private MyStack<Animal> animalStack = null;
	private MyStack<Animal> tempStack = null;
	private static int order = 0;
	
	public static void main(String[] args) {
		Problem7 p = new Problem7(10);
	}
	
	public Animal deque() {
		return animalStack.pop();
	}
	
	public Animal dequeue(String type) {
		while (!animalStack.isEmpty() && !type.equals(animalStack.peek().getType())) {
			tempStack.push(animalStack.pop());
		}
		Animal temp = animalStack.isEmpty() ? null : animalStack.pop();
		while (!tempStack.isEmpty()) {
			animalStack.push(tempStack.pop());
		}
		return temp;
	}
	
	
	
	public Problem7(int size) {
		animalStack = new MyStack<Animal>(size, Animal[].class);
		tempStack = new MyStack<Animal>(size, Animal[].class);
		for (int i=0; i<size; i++) {
			if (i%2 == 0)
				animalStack.push(new Cat(order++) {
				});
			else
				animalStack.push(new Dog(order++));
		}
	}
	
	private abstract class Animal {
		protected String type;
		protected int order;
		public String getType() {
			return type;
		}		
		public int getOrder() {
			return order;
		}	
	}
	
	private class Cat extends Animal {
		private Cat(int order) {
			this.type = "CAT";
			this.order = order;
		}
	}
	
	private class Dog extends Animal {
		private Dog(int order) {
			this.type = "DOG";
			this.order = order;
		}
	}

}
