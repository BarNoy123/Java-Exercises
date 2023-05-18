package hazaratotheapitest;

import java.time.LocalDateTime;
import java.util.Set;

public class BirthdayTask implements Runnable {

	private Set<Person> pepole;

	public BirthdayTask(Set<Person> pepole) {
		super();
		this.pepole = pepole;
	}

	public Set<Person> getPepole() {
		return pepole;
	}

	public void setPepole(Set<Person> pepole) {
		this.pepole = pepole;
	}

	@Override
	public void run() {
		while (true) {
			LocalDateTime localDateTime = LocalDateTime.now();
			for (Person person : pepole) {
				if (person.getBirthday().isBefore(localDateTime) && person.isIspopped() == false) {
					if (person.isSpaciel() == true) {
						person.setIspopped(true);
						SpecialBirthdayTask birthdayTask = new SpecialBirthdayTask(person);
						Thread thread = new Thread(birthdayTask);
						thread.setDaemon(true);
						thread.start();
					} else {
						System.out.println(" !!! HAPPY BIRTHDAY " + person);
						person.setIspopped(true);
					}
				}

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
