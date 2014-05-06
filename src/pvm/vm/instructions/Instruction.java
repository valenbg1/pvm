package pvm.vm.instructions;

import java.util.EmptyStackException;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidMemoryPosException;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.exceptions.NoHeapSpaceException;

public interface Instruction {
	public void execute(PMachine pmachine) throws EmptyStackException,
			InvalidValueTypeException, InvalidMemoryPosException,
			NoHeapSpaceException;

	@Override
	public String toString();
}