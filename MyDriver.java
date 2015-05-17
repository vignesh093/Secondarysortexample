
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MyDriver {
	public static void main(String args[]) throws Exception
	{
		if(args.length!=2)
			{
			System.err.println("Usage: Worddrivernewapi <input path> <output path>");
			System.exit(-1);
			}
		Job job=new Job();
		
		job.setJarByClass(MyDriver.class);
		job.setJobName("MyDriver");
		
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));

		job.setMapperClass(Mymapper.class);
		job.setPartitionerClass(Mypartitioner.class);
		job.setSortComparatorClass(Mysortcomparator.class);
		job.setGroupingComparatorClass(Mygroupcomparator.class);
		job.setReducerClass(MyReducer.class);
		//job.setNumReduceTasks(0);
	
		job.setOutputKeyClass(MyIntWritablepair.class);
		job.setOutputValueClass(NullWritable.class);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}

}
