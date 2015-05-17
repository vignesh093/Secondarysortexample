import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class Mygroupcomparator extends WritableComparator{
	public Mygroupcomparator()
	{
		super(MyIntWritablepair.class,true);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable s1,WritableComparable s2)
	{
		MyIntWritablepair m1=(MyIntWritablepair) s1;
		MyIntWritablepair m2=(MyIntWritablepair) s2;
		return m1.getFirst().compareTo(m2.getFirst());
	}
}
