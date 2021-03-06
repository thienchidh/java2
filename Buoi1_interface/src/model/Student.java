package model;

public class Student extends Person {

	public static final String TYPE_GRADE_A = "A";
	public static final String TYPE_GRADE_B = "B";
	public static final String TYPE_GRADE_C = "C";
	public static final String TYPE_GRADE_D = "D";
	public static final String TYPE_GRADE_FAIL = "ROT";

	private String garde;
	private int mark;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int mark, String garde) {
		super();
		this.mark = mark;
		this.garde = garde;
	}

	public Student(String id, String name, int age) {
		super(id, name, age);
		// TODO Auto-generated constructor stub
	}

	public void calGrade() {
		if (mark >= 8.5) {
			garde = TYPE_GRADE_A;
		} else if (mark >= 7) {
			garde = TYPE_GRADE_B;
		} else if (mark >= 6) {
			garde = TYPE_GRADE_C;
		} else if (mark >= 4) {
			garde = TYPE_GRADE_D;
		} else {
			garde = TYPE_GRADE_FAIL;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (garde == null) {
			if (other.garde != null)
				return false;
		} else if (!garde.equals(other.garde))
			return false;
		if (mark != other.mark)
			return false;
		return true;
	}

	public String getGarde() {
		return garde;
	}

	public int getMark() {
		return mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((garde == null) ? 0 : garde.hashCode());
		result = prime * result + mark;
		return result;
	}

	@Override
	public void input() {
		super.input();
		System.out.println("mark:");
		mark = Integer.parseInt(sc.nextLine());
		calGrade();
	}

	public void setGarde(String garde) {
		this.garde = garde;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [mark=" + mark + ", garde=" + garde + ", id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
