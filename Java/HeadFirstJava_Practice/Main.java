package pers.noah.headfirstjava.main;

import java.util.Scanner;
import java.util.ArrayList;


class Animal
{
    // Variables: picture, food, hungry, boundaries, location
    String food;
    int hunger;
    ArrayList<int> location = new ArrayList<int>();

    // Methods: makeNoise(), eat(), sleep(), roam().
    // makeNoise and eat should belong to the subclass


    public void sleep()
    {
        System.out.println("Sleeping");
    } // close sleep()

    public void roam()
    {
        System.out.println("Roaming");
    } // close roam()
} // close Animal()
class Dog extends Animal
{

}
class Cat extends Animal
{

}
class Wolf extends Animal
{

}
class Hippo extends Animal
{

}
class Lion extends Animal
{

}


public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
    } // close main
} // close Main
