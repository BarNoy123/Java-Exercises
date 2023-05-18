package hazaratotheapitest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Person implements Comparable<Person> {

	private int id;
	private String name;
	private LocalDateTime birthday;
	private boolean ispopped;
	private boolean isSpaciel;
	private static int Counter = 1;

	public Person() {
		this.ispopped = false;
		this.id = Counter;
		this.isSpaciel = false;
		this.name = " Person " + Counter;
		Counter++;

	}

	public Person(int id, String name, LocalDateTime birthday, boolean isSpaciel) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.ispopped = false;
		this.isSpaciel = isSpaciel;
	}

	public boolean isIspopped() {
		return ispopped;
	}

	public boolean isSpaciel() {
		return isSpaciel;
	}

	public void setSpaciel(boolean isSpaciel) {
		this.isSpaciel = isSpaciel;
	}

	public void setIspopped(boolean ispopped) {
		this.ispopped = ispopped;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "id " + id + ", name " + name + DateUtil.beautifyDate(birthday);
	}

	@Override
	public int compareTo(Person other) {
//		if (birthday.equals(other.getBirthday()) && name.equals(other.getName())) {
//			return 0;
//
//		} else {
		return this.birthday.compareTo(other.getBirthday());

	}
}
