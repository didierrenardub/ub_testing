package ar.edu.ub.pcsw.designPatterns.decorator;

import java.util.List;

public interface IStringFilter
{
    String apply(String source);
    String filter(String source);
}
