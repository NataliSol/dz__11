package org.example;

public class BookClub {
    public static String suggestBook(Person person) {
        String bookRecomendation = person instanceof Woman ? "We suggest a new book about yoga to you" : "We suggest a new book about fishing to you";
        return bookRecomendation;
    }
}