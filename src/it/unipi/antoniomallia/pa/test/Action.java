package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.sft.ActionFixture;

public class Action extends ActionFixture {
	public boolean process() {
		Accumulator acc = new Accumulator();
		acc.add(product(12, 12));
		return check(sqrt(acc.add(product(7, 7))));
	}
	private Object sqrt(double add) {
		// TODO Auto-generated method stub
		return null;
	}
	private double product(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	private boolean check(Object obj){
		return obj.equals(13.8924);
	}
}