package pvm.vm.values;

import pvm.vm.exceptions.InvalidValueTypeException;

public interface Value {
	public boolean equals(Value other) throws InvalidValueTypeException;

	public boolean getBool() throws InvalidValueTypeException;

	public int getInt() throws InvalidValueTypeException;

	@Override
	public String toString();
}