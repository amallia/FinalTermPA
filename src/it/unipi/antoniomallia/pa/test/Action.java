package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.sft.ActionFixture;

public class Action extends ActionFixture {
	public boolean process() {
		Accumulator acc = new Accumulator();
		acc.add(product(12, 12));
		return check(sqrt(acc.add(product(7, 7))));
	}

	private boolean check(Object obj) {
		return obj.equals(13.8924);
	}

	private double sqrt(double x) {
		System.out.println(Math.sqrt(x));
		return Math.sqrt(x);

	}

	private double product(double x, double y) {

		return (x * y);
	}
}
