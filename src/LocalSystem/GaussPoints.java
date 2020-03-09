package LocalSystem;

public class GaussPoints {

    public static final IntegralPoint[] gnp = {
            new IntegralPoint(-1 / Math.sqrt(3), -1 / Math.sqrt(3)),
            new IntegralPoint(1 / Math.sqrt(3), -1 / Math.sqrt(3)),
            new IntegralPoint(1 / Math.sqrt(3), 1 / Math.sqrt(3)),
            new IntegralPoint(-1 / Math.sqrt(3), 1 / Math.sqrt(3))
    };

    public static final LocalSurface[] gsp = {
            new LocalSurface(new IntegralPoint(-1.0, 1.0 / Math.sqrt(3.0)), new IntegralPoint(-1.0, -1.0 / Math.sqrt(3.0))),
            new LocalSurface(new IntegralPoint(-1.0 / Math.sqrt(3.0), -1.0), new IntegralPoint(1.0 / Math.sqrt(3.0), -1.0)),
            new LocalSurface(new IntegralPoint(1.0, -1.0 / Math.sqrt(3.0)), new IntegralPoint(1.0, 1.0 / Math.sqrt(3.0))),
            new LocalSurface(new IntegralPoint(1.0 / Math.sqrt(3.0), 1.0), new IntegralPoint(-1.0 / Math.sqrt(3.0), 1.0))
    };
}
