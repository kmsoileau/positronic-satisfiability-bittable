/*
 * BitTableEqualizer.java	1.0 05/04/28
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bittable;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;

public class BitTableEqualizer extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 1L;

  public BitTableEqualizer(IBitTable X, IBitTable Y) throws Exception
  {
    if(!X.isSameSizeAs(Y))
      this.setClauses(MetaProblem.unsolvableProblem().getClauses());
    else
    {
      IProblem[] p=new IProblem[X.numberRows()*X.numberColumns()];
      int count=0;
      for(int i=0;i<X.numberRows();i++)
        for(int j=0;j<X.numberColumns();j++)
          p[count++]=new BitEqualizer(X.getBooleanVariable(i,j),Y.getBooleanVariable(i,j));
      this.setClauses(new Conjunction(p).getClauses());
    }
  }
}