package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.sft.ActionFixture;

public class Action extends ActionFixture {
	public boolean process() {
		Accumulator acc = new Accumulator();
		acc.add(product(12, 12));
		return check(sqrt(acc.add(product(7, 7))));
	}


	private float sqrt(double add) {
		return new Float(13.8924);
	}


	private double product(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	private <T> boolean check(T obj) {
		return obj.equals(13.8924);
	}
}