package com.accessLog;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class ipCountMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	//맵 출력값
		private final static IntWritable outputValue = new IntWritable(1);
		//맵 출력키
		private Text outputKey = new Text();
		
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
			
			logParser parser = new logParser(value);
			
			//출력키 설정
			outputKey.set(parser.getIp());
			
			//출력 데이터 생성
			context.write(outputKey, outputValue);

		}
}