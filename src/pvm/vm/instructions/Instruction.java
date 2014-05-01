package pvm.vm.instructions;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidValueTypeException;

public interface Instruction {
	public void execute(PMachine pmachine) throws IllegalStateException, InvalidValueTypeException;
	@Override
	public String toString();
}