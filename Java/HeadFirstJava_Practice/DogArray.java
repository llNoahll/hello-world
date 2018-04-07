package DogArray;

import java.util.Scanner;


class Dog
{
    char name;
    int size;

    void dark() {
        System.out.println("The dog is darkin");
    }
}


public class DogArray
{
    public static void main(String[] args)
    {
        Dog[] pets;
        pets = new Dog[7];

        pets[0] = new Dog();
        pets[1] = new Dog();

        pets[0].dark();
    }
}
