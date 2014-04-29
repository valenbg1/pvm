package pvm.vm;

class BoolValue extends Value {
	public static boolean popBoolFromStack(PMachine pmachine)
			throws IllegalStateException {
		try {
			return ((BoolValue) pmachine.getStack().pop()).value;
		} catch (Exception e) {
			throw new IllegalStateException("No bool in stack.");
		}
	}

	public final boolean value;

	public BoolValue(boolean value) {
		super(Value_t.BOOL);
		this.value = value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}
}