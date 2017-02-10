/*
 * IBitTable.java	1.0 05/04/28
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bittable;

import positronic.satisfiability.elements.IBooleanVariable;

public interface IBitTable
{
  IBooleanVariable getBooleanVariable(int i, int j);
  String getName();
  boolean isSameSizeAs(IBitTable b);
  int numberColumns();
  int numberRows();
  void setBooleanVariable(int i, int j, IBooleanVariable ib);
}