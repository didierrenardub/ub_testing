package ar.edu.ub.pcsw.designPatterns.nullObject;

public class CBook implements IBook
{
    public CBook(String name, String author, String isbn, int pages)
    {
        this.m_name = name;
        this.m_author = author;
        this.m_isbn = isbn;
        this.m_pages = pages;
    }

    @Override
    public String name()
    {
        return this.m_name;
    }

    @Override
    public String author()
    {
        return this.m_author;
    }

    @Override
    public String isbn()
    {
        return this.m_isbn;
    }

    @Override
    public int pages()
    {
        return this.m_pages;
    }

    @Override
    public String toString()
    {
        return "\"" + this.name() + "\", " + this.author() + " (" + this.isbn() + "). " + this.pages() + " pages long.";
    }

    private String m_name;
    private String m_author;
    private String m_isbn;
    private int m_pages;
}