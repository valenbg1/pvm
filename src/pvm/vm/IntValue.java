package pvm.vm;

class IntValue extends Value {
	public static int popIntFromStack(PMachine pmachine)
			throws IllegalStateException {
		try {
			return ((IntValue) pmachine.getStack().pop()).value;
		} catch (Exception e) {
			throw new IllegalStateException("No int in stack.");
		}
	}

	public final int value;

	public IntValue(int value) {
		super(Value_t.INT);
		this.value = value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}