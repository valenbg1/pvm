package pvm.vm.instructions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

import pvm.vm.PMachine;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.values.BoolValue;
import pvm.vm.values.DoubleValue;
import pvm.vm.values.IntValue;
import pvm.vm.values.Value;

public class IOInstruction implements Instruction {
	public enum IOInstruction_t {
		LEE {
			@Override
			protected void execute(PMachine pmachine)
					throws InvalidValueTypeException {
				Stack<Value> stack = pmachine.stack;
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
					else {
						try {
							stack.push(new DoubleValue(Double.valueOf(in)));
						} catch (NumberFormatException e1) {
							throw new InvalidValueTypeException();
						}
					}
				}

				pmachine.incP_prog();
			}
		},

		ESCRIBE {
			@Override
			protected void execute(PMachine pmachine)
					throws EmptyStackException {
				System.out.println(ESCRIBE.name() + ": "
						+ pmachine.stack.pop());
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(PMachine pmachine)
				throws InvalidValueTypeException, EmptyStackException;
	}

	public final IOInstruction_t ioInstruction_t;

	public IOInstruction(IOInstruction_t ioInstruction_t) {
		this.ioInstruction_t = ioInstruction_t;
	}

	@Override
	public void execute(PMachine pmachine) throws InvalidValueTypeException,
			EmptyStackException {
		ioInstruction_t.execute(pmachine);
	}

	@Override
	public String toString() {
		return this.ioInstruction_t.name();
	}
}