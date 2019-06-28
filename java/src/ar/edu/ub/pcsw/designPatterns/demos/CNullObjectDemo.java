package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.nullObject.*;

import java.util.ArrayList;

public class CNullObjectDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Null object demo";
    }

    @Override
    public void run()
    {
        System.out.println("Traditional Library:");
        this.runTests(new CTraditionalLibrary());
        System.out.println("Null Library:");
        this.runTests(new CNullLibrary());
        System.out.println("Implemented Library:");
        this.runTests(new CLibrary());
    }

    public void runTests(ILibrary onLibrary)
    {
        this.setupLibrary(onLibrary);
        this.trySearchBookByName(onLibrary, "Harry Potter 3");
        this.trySearchBookByName(onLibrary, "Lord of the rings");
        this.trySearchBooksByAuthor(onLibrary, "Rowling");
        this.trySearchBooksByAuthor(onLibrary, "Tolkien");
    }

    public void trySearchBookByName(ILibrary where, String name)
    {
        System.out.println("\t\tTry searching a book by the name of \"" + name + "\"...");
        try
        {
            IBook b = where.book(name);
            if(b.name().equals(name))
            {
                System.out.println("\t\t\tFound: " + b);
            }
            else
            {
                System.out.println("\t\t\tNot found, but no worries: " + b);
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\t\t\tERROR: NullPointerException");
        }
    }

    public void trySearchBooksByAuthor(ILibrary where, String author)
    {
        System.out.println("\t\tTry searching books authored by " + author + "...");
        try
        {
            ArrayList<IBook> books = where.booksByAuthor(author);
            for(IBook b : books)
            {
                if(b.author().contains(author))
                {
                    System.out.println("\t\t\tFound: " + b);
                }
                else
                {
                    System.out.println("\t\t\tNot found, but no worries: " + b);
                }
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("\t\t\tERROR: NullPointerException");
        }
    }

    public void setupLibrary(ILibrary library)
    {
        library.addBook(new CBook("The art of software testing", "Glenford Myers", "978-3-234567-3", 300));
        library.addBook(new CBook("Test Driven Development", "Kent Beck", "978-4-1235671-2", 400));
        library.addBook(new CBook("Harry Potter 1", "J. K. Rowling", "978-5-6138763-6", 600));
        library.addBook(new CBook("Harry Potter 2", "J. K. Rowling", "978-5-6138764-6", 800));
        library.addBook(new CBook("Harry Potter 3", "J. K. Rowling", "978-5-6138765-6", 600));
        library.addBook(new CBook("Harry Potter 4", "J. K. Rowling", "978-5-6138766-6", 700));
        library.addBook(new CBook("Harry Potter 5", "J. K. Rowling", "978-5-6138767-6", 800));
        library.addBook(new CBook("Harry Potter 6", "J. K. Rowling", "978-5-6138768-6", 1000));
        library.addBook(new CBook("Harry Potter 7", "J. K. Rowling", "978-5-6138769-6", 1500));
    }
}
