package pvm.vm.instructions.aux;

import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.values.DoubleValue;
import pvm.vm.values.IntValue;
import pvm.vm.values.Value;

public class NumOps {
	public static Value add(Value op1, Value op2) throws InvalidValueTypeException {
		if ((op1 instanceof DoubleValue) || (op2 instanceof DoubleValue))
			return new DoubleValue(op1.getDouble() + op2.getDouble());
		else
			return new IntValue(op1.getInt() + op2.getInt());
	}
	
	public static Value div(Value op1, Value op2) throws InvalidValueTypeException {
		if ((op1 instanceof DoubleValue) || (op2 instanceof DoubleValue))
			return new DoubleValue(op1.getDouble() / op2.getDouble());
		else
			return new IntValue(op1.getInt() / op2.getInt());
	}
	
	public static Value mul(Value op1, Value op2) throws InvalidValueTypeException {
		if ((op1 instanceof DoubleValue) || (op2 instanceof DoubleValue))
			return new DoubleValue(op1.getDouble() * op2.getDouble());
		else
			return new IntValue(op1.getInt() * op2.getInt());
	}
	
	public static Value neg(Value op1) throws InvalidValueTypeException {
		if (op1 instanceof DoubleValue)
			return new DoubleValue(-op1.getDouble());
		else
			return new IntValue(-op1.getInt());
	}
	
	public static Value sub(Value op1, Value op2) throws InvalidValueTypeException {
		if ((op1 instanceof DoubleValue) || (op2 instanceof DoubleValue))
			return new DoubleValue(op1.getDouble() - op2.getDouble());
		else
			return new IntValue(op1.getInt() - op2.getInt());
	}
}