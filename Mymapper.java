import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Mymapper extends Mapper<LongWritable,Text,MyIntWritablepair,NullWritable> {
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String s=value.toString();
		String s1[]=s.split(",");
			context.write(new MyIntWritablepair(Integer.parseInt(s1[0]),Float.parseFloat(s1[1])), NullWritable.get());
		
	}

}
