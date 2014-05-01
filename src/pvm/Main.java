package pvm;

import java.util.ArrayList;

import pvm.vm.PMachine;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntInstruction;
import pvm.vm.instructions.VoidInstruction;
import pvm.vm.instructions.IntInstruction.IntInstruction_t;
import pvm.vm.instructions.VoidInstruction.VoidInstruction_t;

public class Main {
	public static void main(String[] args) {
		ArrayList<Instruction> prog = new ArrayList<Instruction>();

		/*
		 * int x, y;
		 * 
		 * read x;
		 * 
		 * y:= 2*x / (x+7);
		 * 
		 * write x;
		 * write y;
		 * 
		 */
		prog.add(new VoidInstruction(VoidInstruction_t.LEE));
		prog.add(new IntInstruction(IntInstruction_t.DESAPILA_DIR, 0));
		prog.add(new IntInstruction(IntInstruction_t.APILA, 2));
		prog.add(new IntInstruction(IntInstruction_t.APILA_DIR, 0));
		prog.add(new VoidInstruction(VoidInstruction_t.MULT));
		prog.add(new IntInstruction(IntInstruction_t.APILA_DIR, 0));
		prog.add(new IntInstruction(IntInstruction_t.APILA, 7));
		prog.add(new VoidInstruction(VoidInstruction_t.SUMA));
		prog.add(new VoidInstruction(VoidInstruction_t.DIV));
		prog.add(new IntInstruction(IntInstruction_t.DESAPILA_DIR, 1));
		prog.add(new IntInstruction(IntInstruction_t.APILA_DIR, 0));
		prog.add(new VoidInstruction(VoidInstruction_t.ESCRIBE));
		prog.add(new IntInstruction(IntInstruction_t.APILA_DIR, 1));
		prog.add(new VoidInstruction(VoidInstruction_t.ESCRIBE));

		PMachine pmachine = new PMachine(prog);
		try {
			pmachine.run();
		} catch (Exception e) {
			
			int p_prog = pmachine.getP_prog();
			System.err.println("Error al ejecutar la instrución " + p_prog
					+ ": " + prog.get(p_prog));
			e.printStackTrace();
		}
	}
}