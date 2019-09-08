package test;

import controls.GenericCar;
import controls.ListFlower;
import model.Car;
import model.Flower;

public class TestGenericCar {
	public static void main(String[] args) {
		GenericCar<Car> cars = new GenericCar<>();
		cars.add(new Car("1", "2", "3"));
		cars.add(new Car("2", "3", "4"));
		cars.add(new Car("3", "4", "5"));
		cars.add(new Car("4", "5", "6"));

		cars.display();

		System.out.println("------------");
		ListFlower flowers = new ListFlower();
		flowers.add(new Flower("1", 2.0, "green"));
		flowers.add(new Flower("1", 1.9, "green"));
		flowers.add(new Flower("1", 2.1, "green"));
		flowers.add(new Flower("1", 2.2, "green"));

		System.out.println();
		flowers.display();
		flowers.sort();

		System.out.println();
		flowers.display();
	}
}
