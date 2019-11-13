package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts;

public interface CarPart
{
    String name();
    void setQuality(int quality);
    void setAntiquity(int antiquity);
    float quality();
    int antiquity();
}
