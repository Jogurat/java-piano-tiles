package Piano;

public class Pause extends Symbol{

	public Pause(int duration) {
		super(duration);
	}

	@Override
	public boolean isNote() {
		return false;
	}

	@Override
	public boolean isComplex() {
		return false;
	}

	@Override
	public String toString() {
		return "";
	}

	
}
