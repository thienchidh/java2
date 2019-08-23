package controls;

public interface IOutput {
	default void display() {
		System.out.println(this);
	}
}
