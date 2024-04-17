package aima.gui.demo.logic;

import aima.core.logic.propositional.inference.PLResolution;
import aima.core.logic.propositional.kb.KnowledgeBase;
import aima.core.logic.propositional.parsing.PLParser;

/**
 * @author Ravi Mohan
 * 
 */
public class PlResolutionDemo {
	private static PLResolution plr = new PLResolution();

	public static void main(String[] args) {
		KnowledgeBase kb = new KnowledgeBase();
		String fact = "~JP & ~JM & ~SM & (JP | JK | JM) & (SP | SK | SM) & (CP | CK | CM) & (JP | SP | CP) & (JM | SM | CM) & (JK | SK | CK ) & (JP & SM & CK) & (JM & SK & CP) | (JK & SP & CM)";
		kb.tell(fact);
		System.out.println("\nPlResolutionDemo\n");
		System.out.println("adding " + fact + "to knowldegebase");
 		displayResolutionResults(kb, "JK");
		displayResolutionResults(kb, "SP");
		displayResolutionResults(kb, "CM");
	}

	private static void displayResolutionResults(KnowledgeBase kb, String query) {
		PLParser parser = new PLParser();
		System.out.println("Running plResolution of query " + query
				+ " on knowledgeBase  gives " + plr.isEntailed(kb, parser.parse(query)));
	}
}
