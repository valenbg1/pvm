package pvm.vm.instructions;

import java.util.EmptyStackException;
import java.util.Stack;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidMemoryPosException;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.values.IntValue;
import pvm.vm.values.Value;

public class IntInstruction implements Instruction {
	public enum IntInstruction_t {
		APILA {
			@Override
			protected void execute(int numb, PMachine pmachine) {
				pmachine.getStack().push(new IntValue(numb));
				pmachine.incP_prog();
			}
		},

		APILA_DIR {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws InvalidMemoryPosException {
				Value val = pmachine.getMem().get(numb);

				if (val == null)
					throw new InvalidMemoryPosException();

				pmachine.getStack().push(val);
				pmachine.incP_prog();
			}
		},

		DESAPILA_DIR {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws EmptyStackException {
				pmachine.getMem().put(numb, pmachine.getStack().pop());
				pmachine.incP_prog();
			}
		},

		IR {
			@Override
			protected void execute(int numb, PMachine pmachine) {
				pmachine.setP_prog(numb);
			}
		},

		IR_V {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op = stack.pop();

				if (op.getBool())
					pmachine.setP_prog(numb);
				else
					pmachine.incP_prog();
			}
		},

		IR_F {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op = stack.pop();

				if (!op.getBool())
					pmachine.setP_prog(numb);
				else
					pmachine.incP_prog();
			}
		};

		protected abstract void execute(int numb, PMachine pmachine)
				throws EmptyStackException, InvalidValueTypeException,
				InvalidMemoryPosException;
	}

	private final IntInstruction_t intInstruction_t;
	private final int numb;

	public IntInstruction(IntInstruction_t intInstruction_t, int numb) {
		this.intInstruction_t = intInstruction_t;
		this.numb = numb;
	}

	@Override
	public void execute(PMachine pmachine) throws EmptyStackException,
			InvalidMemoryPosException, InvalidValueTypeException {
		intInstruction_t.execute(numb, pmachine);
	}

	@Override
	public String toString() {
		return this.intInstruction_t.name() + "(" + this.numb + ")";
	}
}