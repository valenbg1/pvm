package pvm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pvm.assembler.PAssembler;
import pvm.vm.PMachine;
import pvm.vm.instructions.Instruction;

public class Main {
	public static void main(String[] args) {
		List<Instruction> prog = null;
		
		try {
			prog = new PAssembler(new BufferedReader(new FileReader("prog.p"))).assemble();
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
	}
}