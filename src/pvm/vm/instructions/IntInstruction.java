package pvm.vm.instructions;

import java.util.EmptyStackException;
import java.util.Map;
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
				pmachine.stack.push(new IntValue(numb));
				pmachine.incP_prog();
			}
		},

		APILA_DIR {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws InvalidMemoryPosException {
				Value val = pmachine.mem.get(numb);

				if (val == null)
					throw new InvalidMemoryPosException();

				pmachine.stack.push(val);
				pmachine.incP_prog();
			}
		},

		DESAPILA_DIR {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws EmptyStackException {
				pmachine.mem.put(numb, pmachine.stack.pop());
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
				Stack<Value> stack = pmachine.stack;
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
				Stack<Value> stack = pmachine.stack;
				Value op = stack.pop();

				if (!op.getBool())
					pmachine.setP_prog(numb);
				else
					pmachine.incP_prog();
			}
		},

		DONA {
			@Override
			protected void execute(int numb, PMachine pmachine)
					throws EmptyStackException, InvalidValueTypeException,
					InvalidMemoryPosException {
				Stack<Value> stack = pmachine.stack;
				Map<Integer, Value> mem = pmachine.mem;
				int op2 = stack.pop().getInt(), op1 = stack.pop().getInt();

				for (int i = 0; i < numb; ++i) {
					Value aux = mem.get(op2 + i);

					if (aux == null)
						throw new InvalidMemoryPosException();

					mem.put(op1 + i, aux);
				}

				pmachine.incP_prog();
			}
		};

		protected abstract void execute(int numb, PMachine pmachine)
				throws EmptyStackException, InvalidValueTypeException,
				InvalidMemoryPosException;
	}

	public final IntInstruction_t intInstruction_t;
	public final int numb;

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