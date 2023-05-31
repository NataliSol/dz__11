package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.BookClub.suggestBook;

public class BookClubTest {

    @Test
    public void suggestBookForWomanTest(){
      Woman woman=new Woman("Nataly", "So", 35);
        Assert.assertEquals(suggestBook(woman), "We suggest a new book about yoga to you","Details message is incorrect");
    }

    @Test
    public void suggestBookNotForWomanTest(){
        Men men=new Men("Ivan", "Petrunov", 23);
        Assert.assertEquals(suggestBook(men), "We suggest a new book about fishing to you","Details message is incorrect");
    }

}