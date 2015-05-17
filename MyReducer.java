import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<MyIntWritablepair,NullWritable,MyIntWritablepair,NullWritable> {
	int count=0;
	public void reduce(MyIntWritablepair key,Iterable<NullWritable> value,Context context) throws IOException,InterruptedException
	{
	context.write(key,NullWritable.get());
	
    }


}
