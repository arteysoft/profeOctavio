package edu.it.ppt.service;

import java.util.Objects;

import edu.it.ppt.enums.ELEMENTOS;

public class DuplaElementos {
	public final ELEMENTOS el1;
	public final ELEMENTOS el2;
	
	public DuplaElementos(ELEMENTOS el1, ELEMENTOS el2) {
		this.el1 = el1;
		this.el2 = el2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(el1, el2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DuplaElementos other = (DuplaElementos) obj;
		return el1 == other.el1 && el2 == other.el2;
	}	
}
