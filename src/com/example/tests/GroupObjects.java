package com.example.tests;

public class GroupObjects {
	public String name;
	public String header;
	public String footer;
	public String id;
	
	public GroupObjects setName(String name) {
		this.name = name;
		return this;
	}
	
	public GroupObjects setHeader(String header) {
		this.header = header;
		return this;
	}
	
	public GroupObjects setFooter(String footer) {
		this.footer = footer;
		return this;
	}
	
	public GroupObjects setId(String id) {
		this.id = id;
		return this;
	}

		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupObjects other = (GroupObjects) obj;
		if (id != null && other.id != null) {
			return id.equals(other.id);
		}	
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [" + id + ": " + name + "]";
	}
	
}