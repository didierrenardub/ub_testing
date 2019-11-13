package ar.edu.ub.pcsw.designPatterns.exercises.racers;

import java.util.ArrayList;

public class Track
{
    public Track()
    {
        this.m_track = new ArrayList<>();
    }

    public Track addPart(TrackPart part)
    {
        this.m_track.add(part);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for(TrackPart tp : this.m_track)
        {
            result.append(tp.toString());
        }
        return result.toString();
    }

    private ArrayList<TrackPart> m_track;
}
