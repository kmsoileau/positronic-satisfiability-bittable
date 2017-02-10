/*
 * BitTable.java	1.0 05/04/28
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bittable;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;

public class BitTable implements IBitTable
{
	/*public static void interpret(List<IBooleanLiteral> list)
  {
    if(list!=null)
      for(int i=0;i<list.size();i++)
        list.get(i).load();
  }*/

	private IBooleanVariable[][] data;
	private String name;

	public BitTable(IBooleanVariable[][] data)
	{
		this("",data);
	}

	/*public BitTable(String name, ArrayList<ArrayList<BooleanVariable>> data)
	{
		this(name,data.toArray(new IBooleanVariable[0][]));
	}*/

	public BitTable(String name,IBooleanVariable[][] data)
	{
		this.setName(name);
		this.setData(data);
	}

	public BitTable(String name, int rows, int columns) throws Exception
	{
		this.setName(name);
		this.data = new IBooleanVariable[rows][columns];
		for(int i=0;i<rows;i++)
			for(int j=0;j<rows;j++)
				this.data[i][j]=BooleanVariable.getBooleanVariable("BT$"+name+"$"+i+"$"+j);
	}

	public IBooleanVariable getBooleanVariable(int i, int j)
	{
		return this.getData()[i][j];
	}

	public IBooleanVariable[][] getData()
	{
		return data;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public boolean isSameSizeAs(IBitTable b)
	{
		if(this.numberColumns()!=b.numberColumns()) return false;
		if(this.numberRows()!=b.numberRows()) return false;
		return true;
	}

	@Override
	public int numberColumns()
	{
		return this.getData()[0].length;
	}

	@Override
	public int numberRows()
	{
		return this.getData().length;
	}

	public void setBooleanVariable(int i, int j, IBooleanVariable ib)
	{
		this.getData()[i][j]=ib;
	}

	public void setData(IBooleanVariable[][] data)
	{
		this.data = data;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public IBitString[] toBitStringArray() throws Exception
	{
		IBitString[] res=new IBitString[numberRows()];
		for(int i=0;i<res.length;i++)
			res[i]=new BitString(this.getName()+"$"+i,this.getData()[i]);
		return res;
	}

	@Override
	public String toString()
	{
		String ret="";
		for(int row=0;row<numberRows();row++)
		{
			for(int column=0;column<this.getData()[0].length;column++)
				if(this.getBooleanVariable(row,column).getValue())
					ret+="T";
				else
					ret+="F";
			ret+="\n";
		}
		return ret;
	}
}