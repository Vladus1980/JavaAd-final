package ua.lviv.lgs.domain;

import java.util.Set;

public class Subject {
	private Integer id;
	private String title;
	private Set<Faculty> faculties;
	
	
	public Subject() {
	}


	public Subject(String title, Set<Faculty> faculties) {
		this.title = title;
		this.faculties = faculties;
	}


	public Subject(Integer id, String title, Set<Faculty> faculties) {
		this.id = id;
		this.title = title;
		this.faculties = faculties;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Set<Faculty> getFaculties() {
		return faculties;
	}


	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculties == null) ? 0 : faculties.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Subject other = (Subject) obj;
		if (faculties == null) {
			if (other.faculties != null)
				return false;
		} else if (!faculties.equals(other.faculties))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", faculties=" + faculties + "]";
	}
	
	
	
	
	
}
