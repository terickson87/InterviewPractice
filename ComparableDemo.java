import java.util.*;
import java.io.*;
import java.lang.*;

class Person implements Comparable<Person> {
   private String name;
   private int age;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   @Override
   public int compareTo(Person person) {
      return this.age - person.age;
   }

   public Person() {
   }

   public Person(String name, int age) {
      this.name = name;
      this.age = age;
   }

}

public class ComparableDemo {
   public static void main(String[] args) {

      List<Person> persons = genPersonsArrayList();

      Collections.sort(persons);
      System.out.println("Using Comparable");
      printPersonList(persons);

      // Using a comparator
      persons = genPersonsArrayList();
      Collections.sort(persons, new Comparator<Person>() {
         public int compare(Person person, Person person1) {
             int nameComparison = person.getName().compareTo(person1.getName());
             if(nameComparison == 0){
                 return nameComparison;
             }
             return person.getAge() - person1.getAge();
         }
      });
      System.out.println("\nUsing Comparator");
      printPersonList(persons);

      // Using Java 8, Name, Age
      persons = genPersonsArrayList();
      persons.sort(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge));
      System.out.println("\nUsing Java 8 - Name, Age");
      printPersonList(persons);

      // Using Java 8, Age, Name
      persons = genPersonsArrayList();
      persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
      System.out.println("\nUsing Java 8 - Age, Name");
      printPersonList(persons);

      // Using Priority Queue with java 8 comparator
      PriorityQueue<Person> personPQ = new PriorityQueue<>( Comparator.comparing(Person::getName).thenComparingInt(Person::getAge) );
      addPersonsToPersonPQ(personPQ);
      System.out.println("\nUsing PriorityQueue - Name, Age");
      printPersonPQ(personPQ);

      // Using Priority Queue with java 8 comparator
      personPQ = new PriorityQueue<>( Comparator.comparing(Person::getName).thenComparingInt(Person::getAge).reversed() );
      addPersonsToPersonPQ(personPQ);
      System.out.println("\nUsing PriorityQueue - Name, Age");
      printPersonPQ(personPQ);
  }

   public static List<Person> genPersonsArrayList() {
      List<Person> persons = new ArrayList<>();
      persons.add(new Person("Umesh Awasthi", 35));
      persons.add(new Person("Robert Hickle", 55));
      persons.add(new Person("John Smith", 40));
      persons.add(new Person("David", 23));
      persons.add(new Person("David", 63));
      return persons;
   }

   public static void printPerson(Person person) {
      System.out.println("Name: " + person.getName() + ", Age:" + person.getAge());
   }

   public static void printPersonList(List<Person> persons) {
      for (Person person : persons) {
         printPerson(person);
      }
   }

   public static void addPersonsToPersonPQ(PriorityQueue<Person> personPQ) {
      personPQ.add(new Person("Umesh Awasthi", 35));
      personPQ.add(new Person("Robert Hickle", 55));
      personPQ.add(new Person("John Smith", 40));
      personPQ.add(new Person("David", 23));
      personPQ.add(new Person("David", 63));
   }

   public static void printPersonPQ(PriorityQueue<Person> personPQ) {
      while (personPQ.size() > 0) {
         printPerson(personPQ.poll());
      }
   }
}