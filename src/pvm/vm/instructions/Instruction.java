package pvm.vm.instructions;

import java.util.EmptyStackException;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidHeapStateException;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.exceptions.NoHeapSpaceException;

public interface Instruction {
	public void execute(PMachine pmachine) throws EmptyStackException,
			InvalidValueTypeException, NoHeapSpaceException,
			InvalidHeapStateException;

	@Override
	public String toString();
}