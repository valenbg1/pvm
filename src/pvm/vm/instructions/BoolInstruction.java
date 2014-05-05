package pvm.vm.instructions;

import pvm.vm.PMachine;
import pvm.vm.values.BoolValue;

public class BoolInstruction implements Instruction {
	public enum BoolInstruction_t {
		APILA {
			@Override
			protected void execute(boolean bool, PMachine pmachine) {
				pmachine.stack.push(new BoolValue(bool));
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(boolean bool, PMachine pmachine);
	}

	public final BoolInstruction_t boolInstruction_t;
	public final boolean bool;

	public BoolInstruction(BoolInstruction_t intInstruction_t, boolean numb) {
		this.boolInstruction_t = intInstruction_t;
		this.bool = numb;
	}

	@Override
	public void execute(PMachine pmachine) {
		boolInstruction_t.execute(bool, pmachine);
	}

	@Override
	public String toString() {
		return this.boolInstruction_t.name() + "(" + this.bool + ")";
	}
}