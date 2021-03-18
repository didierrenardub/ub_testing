package ar.edu.ub.pcsw.designPatterns.factory;

public interface ICandy
{
    String name();
    String description();
    String flavor();
    float price();
    void setPrice(float price);
    ICandy cloneCandy();
}
