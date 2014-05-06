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

	public void free(Segment seg)
			throws InvalidHeapStateException {
		int direction = seg.ini_dir, blocks = seg.size;
		
		if (free_segments.isEmpty())
			free_segments.add(new Segment(direction, blocks));
		else {
			boolean ok = false;
			
			for (ListIterator<Segment> it = free_segments.listIterator(); it.hasNext();) {
				Segment r_seg = it.next(), aux = new Segment(direction, blocks);

				if (direction < r_seg.ini_dir) {
					it.previous();
					it.add(new Segment(direction, blocks));
					it.previous();

					if (it.hasPrevious()) {
						Segment l_seg = it.previous();

						if ((l_seg.ini_dir + l_seg.size) == direction) {
							it.set(aux = new Segment(l_seg.ini_dir, l_seg.size
									+ blocks));
							it.next();
							it.next();
							it.remove();
							it.previous();
						} else if ((l_seg.ini_dir + l_seg.size) > direction)
							throw new InvalidHeapStateException();
					}

					if ((r_seg.ini_dir - blocks) == direction) {
						it.set(new Segment(aux.ini_dir, aux.size + r_seg.size));
						it.next();
						it.next();
						it.remove();
					} else if ((r_seg.ini_dir - blocks) < direction)
						throw new InvalidHeapStateException();

					ok = true;
					break;
				} else if (r_seg.ini_dir == direction)
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