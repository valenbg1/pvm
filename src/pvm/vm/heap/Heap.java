package pvm.vm.heap;

import java.util.LinkedList;
import java.util.ListIterator;

import pvm.vm.exceptions.InvalidHeapStateException;
import pvm.vm.exceptions.NoHeapSpaceException;

public class Heap {
	public final Segment heap_segment = new Segment(65536, 65536 * 2);
	
	private final LinkedList<Segment> free_segments;

	public Heap() {
		super();

		this.free_segments = new LinkedList<Segment>();
		this.free_segments.add(heap_segment);
	}

	public void free(Segment seg) throws InvalidHeapStateException {
		
		if (free_segments.isEmpty())
			free_segments.add(seg);
		else {
			boolean ok = false;
			
			for (ListIterator<Segment> it = free_segments.listIterator(); it.hasNext();) {
				Segment r_seg = it.next();

				if (seg.ini_dir < r_seg.ini_dir) {
					it.previous();
					it.add(seg);
					it.previous();

					if (it.hasPrevious()) {
						Segment l_seg = it.previous();

						if ((l_seg.ini_dir + l_seg.size) == seg.ini_dir) {
							seg = seg.join(l_seg);
							it.set(seg);
							it.next();
							it.next();
							it.remove();
							it.previous();
						} else if ((l_seg.ini_dir + l_seg.size) > seg.ini_dir)
							throw new InvalidHeapStateException();
					}

					if ((seg.ini_dir + seg.size) == r_seg.ini_dir) {
						seg = seg.join(r_seg);
						it.set(seg);
						it.next();
						it.next();
						it.remove();
					} else if ((seg.ini_dir + seg.size) > r_seg.ini_dir)
						throw new InvalidHeapStateException();

					ok = true;
					break;
				} else if (r_seg.ini_dir == seg.ini_dir)
					throw new InvalidHeapStateException();
			}
			
			if (!ok)
				throw new InvalidHeapStateException();
		}
	}

	public Segment malloc(int blocks) throws NoHeapSpaceException {
		for (ListIterator<Segment> it = free_segments.listIterator(); it.hasNext();) {
			Segment seg = it.next();

			if (seg.size >= blocks) {
				it.remove();

				if (seg.size > blocks)
					it.add(new Segment(seg.ini_dir + blocks, seg.size - blocks));

				return new Segment(seg.ini_dir, blocks);
			}
		}

		throw new NoHeapSpaceException();
	}
	
	@Override
	public String toString() {
		return free_segments.toString();
	}
}