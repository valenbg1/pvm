package pvm.vm.values;

import pvm.vm.exceptions.InvalidValueTypeException;

public class DoubleValue implements Value {
	public final double value;

	public DoubleValue(double value) {
		this.value = value;
	}

	@Override
	public boolean equals(Value other) throws InvalidValueTypeException {
		return value == other.getDouble();
	}

	@Override
	public boolean getBool() throws InvalidValueTypeException {
		throw new InvalidValueTypeException();
	}

	@Override
	public double getDouble() throws InvalidValueTypeException {
		return value;
	}

	@Override
	public int getInt() throws InvalidValueTypeException {
		return (int) this.value;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}
}