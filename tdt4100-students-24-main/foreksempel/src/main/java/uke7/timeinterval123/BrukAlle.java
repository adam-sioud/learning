package uke7.timeinterval123;

public class BrukAlle {
    public static void main(String[] args) {
		// lag tidsintervall tilsvarende tirsdagsforelesningen
		TimeInterval1 timeInterval = new TimeInterval1(14, 15, 16, 00);
		// TimeInterval2 timeInterval = new TimeInterval2(14, 15, 16, 00);
		// TimeInterval3 timeInterval = new TimeInterval3(14, 15, 16, 00);
		System.out.println(timeInterval.getStartHour());
		System.out.println(timeInterval.getStartMin());
		// beregn lengden, skal bli 2 * 45 + 15 = 105
		System.out.println(timeInterval.getDuration());
		// skal utløse unntak
		new TimeInterval3(14, 15, 14, 00);
	}
}
