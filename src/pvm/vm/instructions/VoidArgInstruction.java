package pvm.vm.instructions;

import java.util.EmptyStackException;
import java.util.Stack;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.instructions.auxiliar.NumOps;
import pvm.vm.values.BoolValue;
import pvm.vm.values.DoubleValue;
import pvm.vm.values.IntValue;
import pvm.vm.values.Value;

public class VoidArgInstruction implements Instruction {
	public enum VoidInstruction_t {
		SUMA {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(NumOps.add(op1, op2));
				pmachine.incP_prog();
			}
		},

		RESTA {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(NumOps.sub(op1, op2));
				pmachine.incP_prog();
			}
		},

		MUL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(NumOps.mul(op1, op2));
				pmachine.incP_prog();
			}
		},

		DIV {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(NumOps.div(op1, op2));
				pmachine.incP_prog();
			}
		},

		MOD {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new IntValue(op1.getInt() % op2.getInt()));
				pmachine.incP_prog();
			}
		},

		NEG {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op = stack.pop();

				stack.push(NumOps.neg(op));
				pmachine.incP_prog();
			}
		},

		AND {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getBool() && op2.getBool()));
				pmachine.incP_prog();
			}
		},

		OR {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getBool() || op2.getBool()));
				pmachine.incP_prog();
			}
		},

		NOT {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op = stack.pop();

				stack.push(new BoolValue(!op.getBool()));
				pmachine.incP_prog();
			}
		},
		
		TODOUBLE {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op = stack.pop();

				stack.push(new DoubleValue(op.getDouble()));
				pmachine.incP_prog();
			}
		},
		
		TOINT {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op = stack.pop();

				stack.push(new IntValue(op.getInt()));
				pmachine.incP_prog();
			}
		},

		IGUAL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.equals(op2)));
				pmachine.incP_prog();
			}
		},

		DISTINTO {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(!op1.equals(op2)));
				pmachine.incP_prog();
			}
		},

		MENOR {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getDouble() < op2.getDouble()));
				pmachine.incP_prog();
			}
		},

		MAYOR {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getDouble() > op2.getDouble()));
				pmachine.incP_prog();
			}
		},

		MENOROIGUAL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getDouble() <= op2.getDouble()));
				pmachine.incP_prog();
			}
		},

		MAYOROIGUAL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.stack;
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getDouble() >= op2.getDouble()));
				pmachine.incP_prog();
			}
		},

		DUP {
			@Override
			protected void execute(PMachine pmachine)
					throws EmptyStackException {
				pmachine.stack.push(pmachine.stack.peek());
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(PMachine pmachine)
				throws InvalidValueTypeException, EmptyStackException;
	}

	public final VoidInstruction_t voidInstruction_t;

	public VoidArgInstruction(VoidInstruction_t voidInstruction_t) {
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