package com.lijunyu.spring.controller.hadoop;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class WordCount 
{
    public static class WordCountMapper extends MapReduceBase implements Mapper<Object, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(Object key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            StringTokenizer itr = new StringTokenizer(value.toString());
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                output.collect(word, one);
            }

        }
    }

    public static class WordCountReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            result.set(sum);
            output.collect(key, result);
        }
    }

	public static void main(String[] args) throws Exception
{
		System.out.println("WordCount  Main 启动");
        
        
		JobConf job = new JobConf(WordCount.class);
		job.setJarByClass(WordCount.class);
		job.setJobName("wordcount");
		job.addResource("classpath:/hadoop/core-site.xml");
		job.addResource("classpath:/hadoop/hdfs-site.xml");
		job.addResource("classpath:/hadoop/mapred-site.xml");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

//        job.setMapperClass(WordCountMap.class);
//        job.setReducerClass(WordCountReduce.class);
//
//        job.setInputFormatClass(TextInputFormat.class);
//        job.setOutputFormatClass(TextOutputFormat.class);
        
        job.setMapperClass(WordCountMapper.class);
        job.setCombinerClass(WordCountReducer.class);
        job.setReducerClass(WordCountReducer.class);

        job.setInputFormat(TextInputFormat.class);
        job.setOutputFormat(TextOutputFormat.class);

		// 判断output文件夹是否存在，如果存在则删除
		Path path = new Path(args[1]);// 取第1个表示输出目录参数（第0个参数是输入目录）
		FileSystem fileSystem = path.getFileSystem(job);// 根据path找到这个文件
		if (fileSystem.exists(path)) {
			fileSystem.delete(path, true);// true的意思是，就算output有东西，也一带删除
		}
		//20170512chenjie
		// 判断input文件夹是否存在，
		Path inpath = new Path(args[0]);
		if (!fileSystem.exists(path)) {
			fileSystem.mkdirs(inpath);
		}
		
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        JobClient.runJob(job);
     	Path file = new Path(args[2]);//找到输出结果文件
    	FSDataInputStream inStream = fileSystem.open(file);//打开
    	String data = null;
    	while ((data = inStream.readLine()) != null ) {
    		int bt = data.lastIndexOf('\t');
    		System.out.println(data.substring(0,bt) + "出现了" + Integer.parseInt(data.substring(bt+1,data.length())) + "次");
    	}
    	inStream.close();
	}
}
