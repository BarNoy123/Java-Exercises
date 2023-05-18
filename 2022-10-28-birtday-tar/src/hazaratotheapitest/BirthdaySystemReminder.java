package hazaratotheapitest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BirthdaySystemReminder {

	private Set<Person> people;
	private static boolean running = true;
	private Scanner sc;
	private BirthdayTask birthdayTask;

	public BirthdaySystemReminder() {
		people = new HashSet<>();
		sc = new Scanner(System.in);
		birthdayTask = new BirthdayTask(people);
		Thread thread1 = new Thread(birthdayTask);
		thread1.isDaemon();
		thread1.start();
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		BirthdaySystemReminder.running = running;
	}

	public BirthdaySystemReminder(Set<Person> people) {

		this.people = people;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}

	public void ShowMenu() {

		System.out.println("==========Menu==========");
		System.out.println("1. Add member ");
		System.out.println("2. Delete member ");
		System.out.println("3. Print all members in the system ");
		System.out.println("4. Exiting the program ");

	}

	public void startSystem() {

		while (running) {
			ShowMenu();
			int choise = sc.nextInt();
			switch (choise) {
			case 1:
				System.out.println("===please enter id===");
				int id = sc.nextInt();
				System.out.println("===please enter name===");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println(" please enter birthday hh:mm:ss ");
				String bd = sc.nextLine();
				LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(bd));
				System.out.println(" is birthday special");
				boolean special = sc.nextBoolean();
				System.out.println(" ");
				Person person = new Person(id, name, localDateTime, special);
				addPerson(person);
				break;

			case 2:
				System.out.println(" please enter id ");
				int idToFind = sc.nextInt();
				deletePerson(idToFind);
				break;
			case 3:

				List<Person> persons = new ArrayList<>(people);
				Collections.sort(persons);
				for (Person person2 : persons) {

					System.out.println(person2);
				}
				break;
			case 4:
				System.out.println(" goodbye :)");
				running = false;
				return;
			default:
				System.out.println(" invalide imput ");

			}

		}
	}

	public void endSystem() {

	}

	public void addPerson(Person person) {
		if (person != null) {
			people.add(person);

		}

	}

	public void deletePerson(int id) {

		Person p = null;
		for (Person person : people) {
			if (person.getId() == id) {
				p = person;
			}
		}
		if (p == null) {
			System.out.println(" the person id is not found ");

		} else {
			people.remove(p);
		}
	}

	@Override
	public String toString() {
		return " BirthdaySystemReminder people " + people;
	}

}
