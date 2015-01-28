package it.unipi.antoniomallia.pa.model;

import it.unipi.antoniomallia.pa.generator.IHTMLGenerator;

public interface HTMLTag {

	public String toHTML(IHTMLGenerator htmlGen);
}
