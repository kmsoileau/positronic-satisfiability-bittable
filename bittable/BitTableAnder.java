/*
 * BitTableAnder.java	1.0 05/04/28
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bittable;

import positronic.satisfiability.elements.BitAnder;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;

public class BitTableAnder extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -1836438899521241830L;

	public BitTableAnder(IBitTable bitTable1, IBitTable bitTable2, IBitTable bitTable3) throws Exception
	{
		if(!bitTable1.isSameSizeAs(bitTable2) || !bitTable1.isSameSizeAs(bitTable3))
			this.setClauses(MetaProblem.unsolvableProblem().getClauses());
		else
    	{
			IProblem[] p=new IProblem[bitTable1.numberRows()*bitTable1.numberColumns()];
			int count=0;
			for(int i=0;i<bitTable1.numberRows();i++)
				for(int j=0;j<bitTable1.numberColumns();j++)
					p[count++]=new BitAnder(bitTable1.getBooleanVariable(i,j),bitTable2.getBooleanVariable(i,j),bitTable3.getBooleanVariable(i,j));
			this.setClauses(new Conjunction(p).getClauses());
    	}
	}
}