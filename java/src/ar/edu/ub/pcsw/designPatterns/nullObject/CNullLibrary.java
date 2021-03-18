package ar.edu.ub.pcsw.designPatterns.nullObject;

import java.util.ArrayList;

public class CNullLibrary implements ILibrary
{
    public CNullLibrary()
    {
    }

    @Override
    public void addBook(IBook book)
    {
    }

    @Override
    public IBook book(String name)
    {
        return this.m_nullBook;
    }

    @Override
    public ArrayList<IBook> books()
    {
        return this.m_dummy;
    }

    @Override
    public IBook bookByISBN(String isbn)
    {
        return this.m_nullBook;
    }

    @Override
    public ArrayList<IBook> booksByAuthor(String author)
    {
        return this.m_dummy;
    }

    private ArrayList<IBook> m_dummy = new ArrayList<>();
    private CNullBook m_nullBook = new CNullBook();
}
