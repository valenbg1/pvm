package pvm.vm.values;

import pvm.vm.exceptions.InvalidValueTypeException;

public interface Value {

	public int getInt() throws InvalidValueTypeException;
	public boolean getBool() throws InvalidValueTypeException;
	
	@Override
	public String toString();
}