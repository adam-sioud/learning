package uke10.delegering.boss;

public class Secretary extends Worker {

	@Override
	public String work() {
		return "Dette er arbeidet til sekretæren.";
		// Hva vil super være en referanse til, og hva skjer om vi kaller super.work()?
	}

}
