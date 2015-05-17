
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;


public class Mypartitioner extends Partitioner<MyIntWritablepair,NullWritable>{

	@Override
	public int getPartition(MyIntWritablepair key, NullWritable value, int numPartitions) 
	{
		
		return Math.abs(Integer.parseInt(key.getFirst().toString()) * 127) % numPartitions;	
	}

}
