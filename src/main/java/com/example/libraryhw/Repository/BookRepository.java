package com.example.libraryhw.Repository;

public class BookRepository {
    private static int idCounter;

    public static int getLastNumber(){
        return ++idCounter;
    }

}
