package ar.edu.ub.pcsw.designPatterns.exercises.racers;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.trackParts.TrackPart;

import java.util.ArrayList;

public class Track
{
    public Track()
    {
        this.m_track = new ArrayList<>();
    }

    public Track addPart(TrackPart part)
    {
        m_track.add(part);
        return this;
    }

    private ArrayList<TrackPart> m_track;
}
