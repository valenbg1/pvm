package pvm.vm;

public class VoidInstruction implements Instruction {
	public enum VoidInstruction_t {
		SUMA {
			@Override
			protected void execute(PMachine pmachine)
					throws IllegalStateException {
				int op1 = IntValue.popIntFromStack(pmachine), op0 = IntValue
						.popIntFromStack(pmachine);
				pmachine.getStack().push(new IntValue(op0 + op1));
				pmachine.incP_prog();
			}
		},

		RESTA {
			@Override
			protected void execute(PMachine pmachine)
					throws IllegalStateException {
				int op1 = IntValue.popIntFromStack(pmachine), op0 = IntValue
						.popIntFromStack(pmachine);
				pmachine.getStack().push(new IntValue(op0 - op1));
				pmachine.incP_prog();
			}
		},

		MULT {
			@Override
			protected void execute(PMachine pmachine)
					throws IllegalStateException {
				int op1 = IntValue.popIntFromStack(pmachine), op0 = IntValue
						.popIntFromStack(pmachine);
				pmachine.getStack().push(new IntValue(op0 * op1));
				pmachine.incP_prog();
			}
		},

		DIV {
			@Override
			protected void execute(PMachine pmachine)
					throws IllegalStateException {
				int op1 = IntValue.popIntFromStack(pmachine), op0 = IntValue
						.popIntFromStack(pmachine);
				pmachine.getStack().push(new IntValue(op0 / op1));
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(PMachine pmachine)
				throws IllegalStateException;
	}

	private final VoidInstruction_t voidInstruction_t;

	public VoidInstruction(VoidInstruction_t voidInstruction_t) {
		this.voidInstruction_t = voidInstruction_t;
	}

	@Override
	public void execute(PMachine pmachine) throws IllegalStateException {
		voidInstruction_t.execute(pmachine);
	}
}