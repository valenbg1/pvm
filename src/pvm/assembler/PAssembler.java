package pvm.assembler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.instructions.BoolArgInstruction;
import pvm.vm.instructions.BoolArgInstruction.BoolInstruction_t;
import pvm.vm.instructions.DoubleArgInstruction;
import pvm.vm.instructions.DoubleArgInstruction.DoubleInstruction_t;
import pvm.vm.instructions.IOInstruction;
import pvm.vm.instructions.IOInstruction.IOInstruction_t;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;
import pvm.vm.instructions.VoidArgInstruction;
import pvm.vm.instructions.VoidArgInstruction.VoidInstruction_t;

public class PAssembler {
	public static List<Instruction> assemble(BufferedReader file) throws IOException {
		String line = "";
		ArrayList<Instruction> instrs = new ArrayList<Instruction>();
		int row = 0;

		try {
			while ((line = file.readLine()) != null) {
				++row;
				line = line.trim().toUpperCase();

				if (line.equals("") || line.startsWith("//"))
					continue;

				String[] sline = line.split("[(,), ]");

				if (sline.length == 0)
					sline[0] = line;
				
				try {
					instrs.add(new IntArgInstruction(IntInstruction_t.valueOf(sline[0]), Integer.valueOf(sline[1])));
					continue;
				} catch (Exception e) { }
				
				try {
					instrs.add(new DoubleArgInstruction(DoubleInstruction_t.valueOf(sline[0]), Double.valueOf(sline[1])));
					continue;
				} catch (Exception e) { }
				
				try {
					instrs.add(new IOInstruction(IOInstruction_t.valueOf(sline[0])));
					continue;
				} catch (Exception e) { }
				
				try {
					instrs.add(new PointerInstruction(PointerInstruction_t.valueOf(sline[0])));
					continue;
				} catch (Exception e) { }
				
				
				try {
					boolean arg2;
					
					if (sline[1].equalsIgnoreCase("false"))
						arg2 = false;
					else if (sline[1].equalsIgnoreCase("true"))
						arg2 = true;
					else
						throw new InvalidValueTypeException();
					
					instrs.add(new BoolArgInstruction(BoolInstruction_t.valueOf(sline[0]), arg2));
					
					continue;
				} catch (Exception e) { }
				
				try {
					instrs.add(new VoidArgInstruction(VoidInstruction_t.valueOf(sline[0])));
					continue;
				} catch (Exception e) { }

				throw new IOException();
			}
		} catch (Exception e) {
			throw new IOException("Error al leer la línea " + row + ": " + line.toLowerCase());
		}

		return instrs;
	}

	public static void printInstrNumbers(BufferedReader file) throws IOException {
		String line = "";
		int row = 0;

		try {
			while ((line = file.readLine()) != null) {
				line = line.trim();

				if (line.equals("") || line.startsWith("//")) {
					System.out.println(line);
					continue;
				}

				System.out.println(row++ + " " + line);
			}
		} catch (Exception e) {
			throw new IOException("Error al leer la línea " + row + ": " + line.toLowerCase());
		}
	}
}