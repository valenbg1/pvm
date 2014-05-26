package pvm.vm.instructions;

import pvm.vm.PMachine;
import pvm.vm.values.DoubleValue;

public class DoubleArgInstruction implements Instruction {
	public enum DoubleInstruction_t {
		APILA {
			@Override
			protected void execute(double numb, PMachine pmachine) {
				pmachine.stack.push(new DoubleValue(numb));
				pmachine.incP_prog();
			}
		};

		protected abstract void execute(double numb, PMachine pmachine);
	}

	public final DoubleInstruction_t doubleInstruction_t;
	public final double numb;

	public DoubleArgInstruction(DoubleInstruction_t intInstruction_t, double numb) {
		this.doubleInstruction_t = intInstruction_t;
		this.numb = numb;
	}

	@Override
	public void execute(PMachine pmachine) {
		doubleInstruction_t.execute(numb, pmachine);
	}

	@Override
	public String toString() {
		return this.doubleInstruction_t.name() + "(" + this.numb + ")";
	}
}