package pvm.vm;

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
			protected void execute(int numb, PMachine pmachine) {
				pmachine.getStack().push(pmachine.getMem().get(numb));
				pmachine.incP_prog();
			}
		},

		DESAPILA_DIR {
			@Override
			protected void execute(int numb, PMachine pmachine) {
				pmachine.getMem().put(numb, pmachine.getStack().pop());
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(int numb, PMachine pmachine);
	}

	private final IntInstruction_t intInstruction_t;
	private final int numb;

	public IntInstruction(IntInstruction_t intInstruction_t, int numb) {
		this.intInstruction_t = intInstruction_t;
		this.numb = numb;
	}

	@Override
	public void execute(PMachine pmachine) {
		intInstruction_t.execute(numb, pmachine);
	}
}