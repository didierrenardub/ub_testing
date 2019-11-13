package ar.edu.ub.pcsw.designPatterns.exercises.racers;

import java.util.Random;

public class TrackFactoryRandom implements TrackFactory
{
    @Override
    public Track create(int length)
    {
        Track t = new Track();
        Random r = new Random();
        for(int i = 0; i < length; i++)
        {
            TrackPart.GroundType[] gt = TrackPart.GroundType.values();
            TrackPart.SectionType[] st = TrackPart.SectionType.values();
            TrackPart.Steep[] s = TrackPart.Steep.values();
            t.addPart(new TrackPart(gt[r.nextInt(gt.length)], st[r.nextInt(st.length)], s[r.nextInt(s.length)]));
        }
        return t;
    }
}
