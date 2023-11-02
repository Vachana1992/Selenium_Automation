package introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Cls41_JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regularPgm();
		streamFilter();
		StreamMap();
		StreamMerge();
		streamMatch();
		streamCollect();
		assignment();
		

	}
	
	@Test
	public static void regularPgm() {
		List<String> names=new ArrayList<String>();
		names.add("ann");
		names.add("shilpa");
		names.add("achu");
		names.add("anu");
		names.add("Huda");
		names.add("anaina");
		names.add("neha");
		names.add("saj");
		names.add("nachu");
		names.add("afeef");
		names.add("aravind");
		System.out.println(names.size());
		ArrayList<String> nameA=new ArrayList<String>();
		
		for(String name:names) {
			if(name.startsWith("a")) {
				System.out.println(name);
			     nameA.add(name);
				}
			}
		System.out.println(nameA.size());
		
	}
	
	public static void streamFilter() {
		List<String> names=new ArrayList<String>();
		names.add("ann");
		names.add("shilpa");
		names.add("achu");
		names.add("anu");
		names.add("Huda");
		names.add("anaina");
		names.add("neha");
		names.add("saj");
		names.add("nachu");
		names.add("afeef");
		names.add("aravind");
		
		//print the count of names starts with 'a' by using stream
		Long namecount= names.stream().filter(s->s.startsWith("a")).count();
		System.out.println(namecount);
		
		//we can create a new stream and do the stream functions as well
		
		Long count= Stream.of("vachana","Akshara","Narendran","Prabhitha","veena").filter(s->s.startsWith("v")).count();
		System.out.println(count);
		
		
		//Print all the names which has length GT 4 by using streams
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//Get only the first name
		
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	
	public static void StreamMap() {
		
		//print names in the stream  which ends with a  with Uppercase
		Stream.of("vachana","akshara","Narendran","Prabhitha","veena","sai").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which starts with a with uppercase and sorted
		
		Stream.of("vachana","akshara","Narendran","Prabhitha","veena","sai","anu","anaina","athira").filter(s->s.startsWith("a")).sorted().forEach(s->System.out.println(s));
		
		//creating array and convert that into list and then perform the above action
		String[] names= {"vachana","akshara","Narendran","Prabhitha","veena","sai","anu","anaina","athira"};
		List<String> listName= Arrays.asList(names);
		listName.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}
	
	public static void StreamMerge() {
		
		
		List<String> name1=new ArrayList<String>();
		name1.add("neha");
		name1.add("sajna");
		name1.add("nachu");
		name1.add("prathyu");
		
		List<String> name2= Arrays.asList("anu","achu","shilpa","Huda");
		
		//Merging two list into one list and print the name in a sorted order
		Stream<String> NewStream= Stream.concat(name1.stream(), name2.stream());
		NewStream.sorted().forEach(s->System.out.println(s));
		
	}
	
	public static void streamMatch() {
		//1.
		Stream name= Stream.of("anu","chinnu","manu");
		Stream name1= Stream.of("maya","malu");
		Stream newStream=Stream.concat(name, name1);
		
		//finding maya is present
		boolean matchName= newStream.anyMatch(s->s.equals("maya"));
		System.out.println(matchName);
		Assert.assertTrue(matchName);
		
		//2.
		List<String> name3=new ArrayList<String>();
		name3.add("maya");
		name3.add("malu");
		
		
		List<String> name4= Arrays.asList("anu","chinnu","manu");
		
		//finding maya is present
		Stream<String> NewStream= Stream.concat(name3.stream(), name4.stream());
		boolean flag= NewStream.anyMatch(s->s.equalsIgnoreCase("maya"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	public static void streamCollect() {
		
		List<String> ls= Stream.of("anu","achu","shilu").filter(s->s.startsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
	}
	
	public static void assignment() {
		//print the unique number from the array
		//sort the array and give third index
		List<Integer> num=Arrays.asList(3,2,2,7,5,1,9,7);
		List<Integer> ls=num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ls.get(2));
		
	}
	

}
