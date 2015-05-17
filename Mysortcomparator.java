import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public  class Mysortcomparator extends WritableComparator{
	
	protected Mysortcomparator() 
	{
		super(MyIntWritablepair.class,true);
	}
	@SuppressWarnings("rawtypes")
	public int compare(WritableComparable s1,WritableComparable s2)
	{
		MyIntWritablepair m1 = (MyIntWritablepair)s1;
		MyIntWritablepair m2=(MyIntWritablepair) s2;
		int a=m1.getFirst().compareTo(m2.getFirst());
		if(a==0)
		{
			a=-1*m1.getSecond().compareTo(m2.getSecond());
		}
		return a;
	}

}
