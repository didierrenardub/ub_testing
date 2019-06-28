package ar.edu.ub.pcsw.designPatterns.nullObject;

public class CNullBook implements IBook
{
    public CNullBook()
    {
    }

    @Override
    public String name()
    {
        return "NULLBOOK";
    }

    @Override
    public String author()
    {
        return "NOBODY";
    }

    @Override
    public String isbn()
    {
        return "XXX-X-XX-XXXXXX-X";
    }

    @Override
    public int pages()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "\"" + this.name() + "\", " + this.author() + " (" + this.isbn() + "). " + this.pages() + " pages long.";
    }
}
