package pvm.vm.values;

import pvm.vm.exceptions.InvalidValueTypeException;

public class BoolValue implements Value {	
	public final boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	@Override
	public boolean equals(Value other) throws InvalidValueTypeException {
		return value == other.getBool();
	}

	@Override
	public boolean getBool() throws InvalidValueTypeException {
		return this.value;
	}

	@Override
	public int getInt() throws InvalidValueTypeException {
		throw new InvalidValueTypeException();
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}
}