/*
 * BitTableFixer.java	1.0 05/04/15
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bittable;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;

public class BitTableFixer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1189539238569048584L;

	public BitTableFixer(IBitTable bitTable) throws Exception
	{
		IProblem[] p=new BitFixer[bitTable.numberRows()*bitTable.numberColumns()];
		int count=0;
		for(int i=0;i<bitTable.numberRows();i++)
			for(int j=0;j<bitTable.numberColumns();j++)
				p[count++]=new BitFixer(bitTable.getBooleanVariable(i,j));
		this.setClauses(new Conjunction(p).getClauses());
	}
}