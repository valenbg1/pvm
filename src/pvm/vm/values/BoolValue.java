package pvm.vm.values;

import pvm.vm.exceptions.InvalidValueTypeException;

public class BoolValue implements Value {

	public final boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}

	@Override
	public int getInt() throws InvalidValueTypeException {
		throw new InvalidValueTypeException();
	}

	@Override
	public boolean getBool() throws InvalidValueTypeException {
		return this.value;
	}
}