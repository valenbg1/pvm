package pvm.assembler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.instructions.BoolArgInstruction;
import pvm.vm.instructions.BoolArgInstruction.BoolInstruction_t;
import pvm.vm.instructions.IOInstruction;
import pvm.vm.instructions.IOInstruction.IOInstruction_t;
import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntArgInstruction;
import pvm.vm.instructions.IntArgInstruction.IntInstruction_t;
import pvm.vm.instructions.PointerInstruction;
import pvm.vm.instructions.PointerInstruction.PointerInstruction_t;
import pvm.vm.instructions.VoidInstruction;
import pvm.vm.instructions.VoidInstruction.VoidInstruction_t;

public class PAssembler {
	private int row;
	private final BufferedReader file;

	public PAssembler(BufferedReader file) {
		this.row = 0;
		this.file = file;
	}

	public List<Instruction> assemble() throws IOException {
		String line = "";
		ArrayList<Instruction> instrs = new ArrayList<Instruction>();

		try {
			while ((line = file.readLine()) != null) {
				++row;
				line = line.toUpperCase();

				if (line.equals("") || line.startsWith("//"))
					continue;

				String[] sline = line.split("[(, )]");

				if (sline.length == 0)
					sline[0] = line;
				
				try {
					instrs.add(new IntArgInstruction(IntInstruction_t.valueOf(sline[0]), Integer.valueOf(sline[1])));
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
					instrs.add(new VoidInstruction(VoidInstruction_t.valueOf(sline[0])));
					continue;
				} catch (Exception e) { }

				throw new IOException();
			}
		} catch (Exception e) {
			throw new IOException("Error al leer la línea " + row + ": " + line);
		}

		return instrs;
	}
}