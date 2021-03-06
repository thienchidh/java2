package ex3.model;

import java.util.Scanner;

public class Rectangle {
	private static Scanner sc = new Scanner(System.in);

	private float width;
	private float height;

	public Rectangle() {
		super();
	}

	public Rectangle(float width, float height) {
		super();
		this.width = width;
		this.height = height;
	}

	public float caculateArea() {
		return height * width;
	}

	public float caculatePerimeter() {
		return 2 * (height + width);
	}

	public void display() {
		System.out.println(this);
	}

	public void input() {
		System.out.println("enter width");
		width = Float.parseFloat(sc.nextLine());
		System.out.println("enter height");
		height = Float.parseFloat(sc.nextLine());
	}
}
