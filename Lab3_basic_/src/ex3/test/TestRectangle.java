package ex3.test;

import ex3.model.Rectangle;

public class TestRectangle {
	public static void main(String[] args) {
//		new Rectangle().display();
//
//		new Rectangle(2.0f, 2.0f).display();

		Rectangle rectangle = new Rectangle();
		rectangle.input();

		System.out.println(rectangle.caculateArea());

		System.out.println(rectangle.caculatePerimeter());
	}
}