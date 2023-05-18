package hazaratotheapitest;

public class SpecialBirthdayTask implements Runnable {

	private Person person;

	public SpecialBirthdayTask(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void run() {

		for (int i = 0; i < 2; i++) {
			System.out.println(" Special happy birthday" + person.getName());
			try {
				Thread.sleep(1000 * 60);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}
