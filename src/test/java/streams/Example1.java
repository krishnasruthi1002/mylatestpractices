package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

public class Example1 {

	
	public void regular() {
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhi");
		names.add("Ammulu");
		names.add("Avuthu");
		names.add("Sruthi");
		names.add("Reddy");
		names.add("Lankapothu");
		
		for(int i=0;i<names.size();i++) {
			String requiredname= names.get(i);
			if (requiredname.startsWith("A")) {
				System.out.println(requiredname);
			}
		}
		
	}
	
	public void streamFilter() {
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhi");
		names.add("Ammulu");
		names.add("Avuthu");
		names.add("Sruthi");
		names.add("Reddy");
		names.add("Lankapothu");
		List<String> name= Arrays.asList("Abhi","Ammulu","Avuthu","Sruthi","Reddy","Lankapothu");
	Long c=	names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(c);
	
	//another way of writing the stream in single line
	long d= Stream.of("Abhi","Ammulu","Avuthu","Sruthi","Reddy","Lankapothu").filter(s->{
		s.startsWith("A");
		//if we write return faslse we will not get the output
		return true;
		
	}).count();
	System.out.println(d);
	names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	
	//suppose if we want print only the first value with the given condition
	names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	
	//convert to upper case
	Stream.of("Abhi","Ammulu","Avuthu","Sruthi","Reddy","Lankapothu").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//merging two different lists
	Stream<String> newstream= Stream.concat(names.stream(), name.stream());
	newstream.sorted().forEach(s->System.out.println(s));
	
boolean flag=	newstream.anyMatch(s->s.equalsIgnoreCase("Ammulu"));
Assert.assertTrue(flag);

//to create new list from the output
List<String> ls=Stream.of("Abhi","Ammulu","Avuthu","Sruthi","Reddy","Lankapothu").filter(s->s.endsWith("i")).map(s->s.toUpperCase())
.collect(Collectors.toList());
System.out.println(ls.get(1));

ls.stream().distinct().forEach(s->System.out.println(s));
List<Object> ls1=ls.stream().sorted().collect(Collectors.toList());
System.out.println(ls1);

	}
	public static void main(String[] args) {
		Example1 e= new Example1();
		e.streamFilter();

	}

}
