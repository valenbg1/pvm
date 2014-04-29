package pvm.vm;

abstract class Value {
	public enum Value_t {
		INT, BOOL;
	}

	public final Value_t value_t;

	protected Value(Value_t value_t) {
		this.value_t = value_t;
	}

	@Override
	public abstract String toString();
}