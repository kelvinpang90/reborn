package com.reborn;

import com.reborn.test.lambda.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Stream_Sample {
    public static void main(String[] args){
        List<Person> persons = getList();
        persons.stream().filter(person -> person.getAge()<30).forEach(System.out::println);
        System.out.println(persons.stream().filter(person -> person.getGender()==Person.SEX.MALE).count());
        System.out.println(persons.stream().count());
        System.out.println(persons.stream().mapToInt(Person::getAge).sum());
        System.out.println(persons.stream().mapToInt(Person::getAge).limit(5));

        //方法调用：接口的convert方法实现，通过调用Stream_Sample的string2Int()；
        Converter<String,Integer> converter = Stream_Sample::string2Int;
        int i = converter.convert("123");
        System.out.println(i);
        converter.convert2();
        System.out.println();
        predicateTest();
    }

    @Test
    public static List<Person> getList(){
        Person p1 = new Person("Peter", Person.SEX.MALE,"abc@hotmail.com", LocalDate.of(1995,10,10));
        Person p2 = new Person("Kate", Person.SEX.FEMALE,"def@hotmail.com",LocalDate.of(1998,1,22));
        Person p3 = new Person("Brown", Person.SEX.MALE,"ghi@hotmail.com",LocalDate.of(1988,5,4));
        Person p4 = new Person("Ryan", Person.SEX.MALE,"ssa@hotmail.com",LocalDate.of(1985,5,4));
        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        return persons;
    }

    //注解表示功能性接口，且接口只能有一个方法
    @FunctionalInterface
    interface Converter<F,T>{
        T convert(F from);
        default void convert2(){
            System.out.println(456);
        }
    }

    @Test
    public static int string2Int(String str){
        return Integer.valueOf(str);
    }

    @Test
    public static void predicateTest(){
        Predicate<String> predicate = s -> s.length()>0;
        System.out.println(predicate.test("abc"));
        System.out.println(predicate.test(""));
    }

    @Test
    public static void functionTest(){
        Function<String,Integer> toInteger = Integer::valueOf;
        Function<String, Object> toString = toInteger.andThen(String::valueOf);

        System.out.println(toString.apply("123"));
    }

    @Test
    public static void consumerTest(){
        Consumer<Integer> consumer = p->{
            System.out.println(p);
            p+=5;
            System.out.println(p);
        };
        consumer.accept(10);
    }

    @Test
    public static int supplierTest(){
        Supplier<Integer> supplier = ()->123;
        return supplier.get();
    }
}
