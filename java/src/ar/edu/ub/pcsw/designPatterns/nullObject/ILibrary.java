package ar.edu.ub.pcsw.designPatterns.nullObject;

import java.util.ArrayList;

public interface ILibrary
{
    void addBook(IBook book);
    IBook book(String name);
    ArrayList<IBook> books();
    IBook bookByISBN(String isbn);
    ArrayList<IBook> booksByAuthor(String author);
}