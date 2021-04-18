package ua.lviv.lgs.domain;

import java.util.Map;

public class Entration {
	
	private Integer id;
	private Entrant entrant;
	private Speciality speciality;
	private Map<Subject, Integer> marksOfZNO;
	private Integer attMark;
	
	
	public Entration() {
	}


	public Entration(Entrant entrant, Speciality speciality, Map<Subject, Integer> marksOfZNO, Integer attMark) {
		this.entrant = entrant;
		this.speciality = speciality;
		this.marksOfZNO = marksOfZNO;
		this.attMark = attMark;
	}


	public Entration(Integer id, Entrant entrant, Speciality speciality, Map<Subject, Integer> marksOfZNO,
			Integer attMark) {
		this.id = id;
		this.entrant = entrant;
		this.speciality = speciality;
		this.marksOfZNO = marksOfZNO;
		this.attMark = attMark;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Entrant getEntrant() {
		return entrant;
	}


	public void setEntrant(Entrant entrant) {
		this.entrant = entrant;
	}


	public Speciality getSpeciality() {
		return speciality;
	}


	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}


	public Map<Subject, Integer> getMarksOfZNO() {
		return marksOfZNO;
	}


	public void setMarksOfZNO(Map<Subject, Integer> marksOfZNO) {
		this.marksOfZNO = marksOfZNO;
	}


	public Integer getAttMark() {
		return attMark;
	}


	public void setAttMark(Integer attMark) {
		this.attMark = attMark;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attMark == null) ? 0 : attMark.hashCode());
		result = prime * result + ((entrant == null) ? 0 : entrant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marksOfZNO == null) ? 0 : marksOfZNO.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entration other = (Entration) obj;
		if (attMark == null) {
			if (other.attMark != null)
				return false;
		} else if (!attMark.equals(other.attMark))
			return false;
		if (entrant == null) {
			if (other.entrant != null)
				return false;
		} else if (!entrant.equals(other.entrant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marksOfZNO == null) {
			if (other.marksOfZNO != null)
				return false;
		} else if (!marksOfZNO.equals(other.marksOfZNO))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Entration [id=" + id + ", entrant=" + entrant + ", speciality=" + speciality + ", marksOfZNO="
				+ marksOfZNO + ", attMark=" + attMark + "]";
	}
	
	

}
