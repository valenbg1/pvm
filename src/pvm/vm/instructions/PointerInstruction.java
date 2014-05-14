package pvm.vm.instructions;

import java.util.EmptyStackException;
import java.util.Stack;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.values.IntValue;
import pvm.vm.values.Value;

public class PointerInstruction implements Instruction {
	public enum PointerInstruction_t {
		APILA_IND {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op = stack.pop(), aux = pmachine.mem
						.get(op.getInt());

				if (aux == null)
					aux = new IntValue(0);
					
				stack.push(aux);
				pmachine.incP_prog();
			}
		},

		DESAPILA_IND {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				pmachine.mem.put(op1.getInt(), op2);
				pmachine.incP_prog();
			}
		},
		
		IR_IND {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				pmachine.setP_prog(pmachine.stack.pop().getInt());
			}
		};

		protected abstract void execute(PMachine pmachine)
				throws InvalidValueTypeException, EmptyStackException;
	}

	public final PointerInstruction_t pointerInstruction_t;

	public PointerInstruction(PointerInstruction_t ioInstruction_t) {
		this.pointerInstruction_t = ioInstruction_t;
	}

	@Override
	public void execute(PMachine pmachine) throws InvalidValueTypeException,
			EmptyStackException {
		pointerInstruction_t.execute(pmachine);
	}

	@Override
	public String toString() {
		return this.pointerInstruction_t.name();
	}
}