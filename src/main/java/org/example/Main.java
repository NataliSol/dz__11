package org.example;

public class Main {
    public static void main(String[] args) {
        Woman angelina = new Woman("Angelina", "Jolie", 45);
        Woman scarlett = new Woman("Scarlett", "Johansson", 40);
        Woman jennifer = new Woman("Jennifer", "Lawrence", 34);
        Men brad = new Men("Brad", "Pitt", 40);
        Men hugh = new Men("Hugh", "Jackman", 42);
        Men robert = new Men("Robert", "Downe", 45);
        BookClub bookClub=new BookClub();
        angelina.registerPartnership(brad);
        angelina.registerPartnership(hugh);
        System.out.println(angelina.getLastName());
        angelina.deregisterPartnership();
        System.out.println(angelina.getLastName());
        angelina.introduce();
        angelina.introduceSuper();
        System.out.println(BookClub.suggestBook(angelina));
    }
}
