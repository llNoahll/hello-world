package practice;

import java.util.Scanner;


public class a_practice
{
    public static void main(String[] args)
    {
        Dog d = new Dog();
        d.size = 40;
        d.bark();
    }
}

class Dog
{
    int size;
    String breed;
    String name;

    void bark() {
        System.out.println("Ruff! Ruff!");
    }
}
