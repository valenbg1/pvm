package pvm.vm.instructions;

import java.util.EmptyStackException;
import java.util.Stack;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.values.*;

public class VoidInstruction implements Instruction {
	public enum VoidInstruction_t {
		SUMA {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new IntValue(op1.getInt() + op2.getInt()));
				pmachine.incP_prog();
			}
		},

		RESTA {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new IntValue(op1.getInt() - op2.getInt()));
				pmachine.incP_prog();
			}
		},

		MULT {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new IntValue(op1.getInt() * op2.getInt()));
				pmachine.incP_prog();
			}
		},

		DIV {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new IntValue(op1.getInt() / op2.getInt()));
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(PMachine pmachine)
				throws InvalidValueTypeException, EmptyStackException;
	}

	private final VoidInstruction_t voidInstruction_t;

	public VoidInstruction(VoidInstruction_t voidInstruction_t) {
		this.voidInstruction_t = voidInstruction_t;
	}

	@Override
	public void execute(PMachine pmachine) throws InvalidValueTypeException,
			EmptyStackException {
		voidInstruction_t.execute(pmachine);
	}

	@Override
	public String toString() {
		return this.voidInstruction_t.name();
	}
}