package b3.model;

public class Fraction {
	private int ts;
	private int ms;

	public Fraction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fraction(int ts, int ms) {
		super();
		this.ts = ts;
		this.ms = ms;
	}

	public double compute() throws FractionExepction {
		if (ms == 0) {
			throw new FractionExepction();
		}
		double rs = ts * 1.0 / ms * 1.0;
		return rs;
	}

	public void setMs(int ms) {
		this.ms = ms;
	}

	public void setTs(int ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		return "Fraction [ts=" + ts + ", ms=" + ms + "]";
	}

}