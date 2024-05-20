package uke10.delegering.boss.uteninterface;

public class Boss extends Worker {

	Worker secretary;
	
	@Override
	public String work() {

		if (this.secretary != null) {
			return secretary.work();
		}
		return "Boss doin' work";

	}

	public void setSecretary(Worker secretary) {
		this.secretary = secretary;
	}


	public static void main(String[] args) {
		Boss boss = new Boss();
		System.out.println(boss.work());
		boss.setSecretary(new Secretary());
		System.out.println(boss.work());
	}
}
