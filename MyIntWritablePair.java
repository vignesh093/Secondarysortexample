import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;


public class MyIntWritablepair implements WritableComparable<MyIntWritablepair> {
	public IntWritable first;
	public FloatWritable second;
	public MyIntWritablepair()
	{
		
	}
	public MyIntWritablepair(MyIntWritablepair o)
	{
		this.first=o.first;
		this.second=o.second;
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		
		first.readFields(in);
		second.readFields(in);
	}

	@Override
	public void write(DataOutput out) throws IOException {
	
		first.write(out);
		second.write(out);		
	}
	
	public void setFirst(IntWritable first)
	{
		this.first=first;
	}
	public void setSecond(FloatWritable second)
	{
		this.second=second;
	}
	public IntWritable getFirst()
	{
		return first;
	}
	public FloatWritable getSecond()
	{
		return second;
	}
	public MyIntWritablepair(IntWritable first,FloatWritable second)
	{
		this.first=first;
		this.second=second;
	}
	public MyIntWritablepair(Integer first,Float second)
	{
		this.first=new IntWritable(first);
		this.second=new FloatWritable(second);
		
	}
	@Override
	public int compareTo(MyIntWritablepair o) {
		int a=first.compareTo(o.first);
		if(a==0)
		{
			a=second.compareTo(o.second);
		}
		return a;
	}
	  @Override
	    public String toString() {
	        return first + " " + second;
	    }
}
