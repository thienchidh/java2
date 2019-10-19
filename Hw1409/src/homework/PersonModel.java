package homework;

import java.util.ArrayList;

public class PersonModel<T> {
	public static void main(String[] args) {

		PersonModel<Student> st = new PersonModel<>();
		st.addObject(new Student("AO165122", "Nguyen Van Ti", 20));
		st.addObject(new Student("AO165170", "Tran Van Teo", 22));
		st.display();
		PersonModel<Employee> ep = new PersonModel<>();
		ep.addObject(new Employee("A55483", "Emp1", 10000));
		ep.addObject(new Employee("A55233", "Emp2", 500000));
		ep.display();
		PersonModel<String> sr = new PersonModel<>();
		sr.addObject("Ho");
		sr.addObject("Bao");
		sr.display();

	}

	private ArrayList<T> al = new ArrayList<T>();

	private T obj;

	public PersonModel() {

	}

	public PersonModel(T obj) {
		this.obj = obj;
	}

	public void addObject(T obj) {
		al.add(obj);
	}

	public void display() {
		for (T o : al) {
			System.out.println(o);
		}
	}

	public T getObj() {
		return obj;
	}

}