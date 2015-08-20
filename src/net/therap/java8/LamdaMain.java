package net.therap.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaMain {

    public static void main(String[] args) {
        
        // Lets start with a very simple code
        // We have a list of integer.
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        // We want to print each integer.
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
        
        // Is it familiar?
        // Sure we have write codes like this thousand times.
        // Is it easy? 
        
        
        // Now can we improve it ? 
        // Sure, we are going to use for each loop.
        for (Integer value : values) {
            System.out.println(value);
        }
        
        // Why it is improved?
        // Because it's more simple.
        
        
        // Both of these loops are called external iterator.
        // Meaning we are doing the looping by ourselves.
        
        // But we wanted to print the integers only.
        // Is not that violates separation of concern principle?
        
        // In Java 8 we can write
        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        
        // Lets concentrate on the forEach method for a little bit.
        // Here the forEach method is going to take care of the lopping.
        // Now we do not care how the looping works that's not our concern.
        // It's a new functionality added in Iterable interface.
        // It's done so using default keyword.
        // Using default key word you can add new functionality to existing java interface.
        
        // But wait does that means we are going to write yet another Anonymous Inner Class ?
        // we are not going to do this
        // This code has a lot of ceremony.
        // We are only interested in System.out.println(value);
        
        // To your relief you don't have to write the ceremony codes in java 8.
        values.forEach((Integer value) -> System.out.println(value));
       
        // What we have done? We have passed an anonymous function to our forEach method.
        // A function has 4 things: parameters, return type , name and body.
        // From context we can figure out the return type and function name really does not mean anything
        // Whats important is parameter and the function body. And we have sent exactly these two. No more ceremony.


        // We can refactor our code one more time 
        // We are iterating over a list of integers. So what is the type of each element?
        // Integer of course it's obvious. And we are java programmers we do not write obvious things.
        // We have trained our ide and compilers to do that for us.
        
        values.forEach(value -> System.out.println(value));
        
        // Finally what is the purpose of the variable value here?
        // It's following office coordinator anti pattern.
        // Like a coordinator the variable is taking a value from one place and then pass it to another.
        // It's doing nothing else. This is stupid and we do not write stupid codes.
        
        // So what we do? We use a new feature called method reference
        values.forEach(System.out::println);
        
        // Final thing on this topic is invoke dynamic.
        // Lambdas are not syntactic sugar for 'Functional Interfaces'
        // For each anonymous inner class compiler creates .class file during compile time.
        // Instead of implementing lambdas with anonymous inner class java 8  have used a new feature
        // introduced in JAVA7 (Yes you heard right JAVA7) called invoke dynamic.
    }
}
