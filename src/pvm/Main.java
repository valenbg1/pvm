package pvm;

import java.util.ArrayList;

import pvm.vm.Instruction;
import pvm.vm.IntInstruction;
import pvm.vm.IntInstruction.IntInstruction_t;
import pvm.vm.PMachine;
import pvm.vm.VoidInstruction;
import pvm.vm.VoidInstruction.VoidInstruction_t;

public class Main {
	public static void main(String[] args) {
		ArrayList<Instruction> prog = new ArrayList<Instruction>();

		/*
		 * int x, y;
		 * 
		 * x:= 25;
		 * y:= 2*x / (x+7);
		 * 
		 */
		prog.add(new IntInstruction(IntInstruction_t.APILA, 25));
		prog.add(new IntInstruction(IntInstruction_t.DESAPILA_DIR, 0));
		prog.add(new IntInstruction(IntInstruction_t.APILA, 2));
		prog.add(new IntInstruction(IntInstruction_t.APILA_DIR, 0));
		prog.add(new VoidInstruction(VoidInstruction_t.MULT));
		prog.add(new IntInstruction(IntInstruction_t.APILA_DIR, 0));
		prog.add(new IntInstruction(IntInstruction_t.APILA, 7));
		prog.add(new VoidInstruction(VoidInstruction_t.SUMA));
		prog.add(new VoidInstruction(VoidInstruction_t.DIV));
		prog.add(new IntInstruction(IntInstruction_t.DESAPILA_DIR, 1));

		PMachine pmachine = new PMachine(prog);
		pmachine.run();

		System.out.println(pmachine.getMem().get(0));
		System.out.println(pmachine.getMem().get(1));
	}
}