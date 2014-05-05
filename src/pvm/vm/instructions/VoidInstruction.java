package pvm.vm.instructions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.values.BoolValue;
import pvm.vm.values.IntValue;
import pvm.vm.values.Value;

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

		MUL {
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
		},
		
		MOD {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new IntValue(op1.getInt() % op2.getInt()));
				pmachine.incP_prog();
			}
		},
		
		NEG {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op = stack.pop();

				stack.push(new IntValue(-op.getInt()));
				pmachine.incP_prog();
			}
		},
		
		AND {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getBool() && op2.getBool()));
				pmachine.incP_prog();
			}
		},
		
		OR {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getBool() || op2.getBool()));
				pmachine.incP_prog();
			}
		},
		
		NOT {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op = stack.pop();

				stack.push(new BoolValue(!op.getBool()));
				pmachine.incP_prog();
			}
		},
		
		IGUAL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.equals(op2)));
				pmachine.incP_prog();
			}
		},
		
		DISTINTO {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(!op1.equals(op2)));
				pmachine.incP_prog();
			}
		},
		
		MENOR {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getInt() < op2.getInt()));
				pmachine.incP_prog();
			}
		},
		
		MAYOR {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getInt() > op2.getInt()));
				pmachine.incP_prog();
			}
		},
		
		MENOROIGUAL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getInt() <= op2.getInt()));
				pmachine.incP_prog();
			}
		},
		
		MAYOROIGUAL {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException, EmptyStackException {
				Stack<Value> stack = pmachine.getStack();
				Value op2 = stack.pop(), op1 = stack.pop();

				stack.push(new BoolValue(op1.getInt() >= op2.getInt()));
				pmachine.incP_prog();
			}
		},

		LEE {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException {
				Stack<Value> stack = pmachine.getStack();
				String in;

				System.out.print(LEE.name() + ": ");

				try {
					in = new BufferedReader(new InputStreamReader(System.in))
							.readLine();
				} catch (IOException e1) {
					throw new InvalidValueTypeException();
				}

				try {
					stack.push(new IntValue(Integer.valueOf(in)));
				} catch (NumberFormatException e) {
					if (in.equalsIgnoreCase("false"))
						stack.push(new BoolValue(false));
					else if (in.equalsIgnoreCase("true"))
						stack.push(new BoolValue(true));
					else
						throw new InvalidValueTypeException();
				}

				pmachine.incP_prog();
			}
		},

		ESCRIBE {
			@Override
			protected void execute(PMachine pmachine)
					throws EmptyStackException {
				System.out.println(ESCRIBE.name() + ": "
						+ pmachine.getStack().pop());
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