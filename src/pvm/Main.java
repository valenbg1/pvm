package pvm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pvm.assembler.PAssembler;
import pvm.vm.PMachine;
import pvm.vm.instructions.Instruction;

public class Main {
	public static void main(String[] args) {
		List<Instruction> prog = null;
		
		try {
			PAssembler.printInstrNumbers(new BufferedReader(new FileReader("bprog-valen.p")));
			prog = PAssembler.assemble(new BufferedReader(new FileReader("bprog-valen.p")));
			System.out.println();
		} catch (FileNotFoundException e1) {
			System.err.println("No se encuentra el archivo");
			e1.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		PMachine pmachine = new PMachine(prog);
		
		try {
			pmachine.run();
		} catch (Exception e) {
			
			int p_prog = pmachine.getP_prog();
			System.err.println("Error al ejecutar la instrución " + p_prog
					+ ": " + prog.get(p_prog));
			e.printStackTrace();
			return;
		}
		
		System.out.println("\nMem trace:");

		List<Integer> keys = new ArrayList<Integer>(pmachine.mem.keySet());
		Collections.sort(keys);
		for (Integer key : keys)
		    System.out.println(key + ": " + pmachine.mem.get(key));

		System.out.println("\nHeap trace:\n" + pmachine.heap);

		System.out.println("\nStack trace:\n" + pmachine.stack);
	}
}