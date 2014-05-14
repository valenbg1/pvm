package pvm.vm.values;

import pvm.vm.exceptions.InvalidValueTypeException;

public class IntValue implements Value {
	public final int value;

	public IntValue(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Value other) throws InvalidValueTypeException {
		return value == other.getInt();
	}

	@Override
	public boolean getBool() throws InvalidValueTypeException {
		throw new InvalidValueTypeException();
	}

	@Override
	public int getInt() throws InvalidValueTypeException {
		return this.value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}