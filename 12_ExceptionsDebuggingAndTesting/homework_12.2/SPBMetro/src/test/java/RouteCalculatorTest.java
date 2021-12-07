import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    private List<Station> route;
    private StationIndex stationIndex;
    private RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "A");
        Line line2 = new Line(2, "B");
        Line line3 = new Line(3, "C");

        Station A1 = new Station("A1", line1);
        Station A2 = new Station("A2", line1);
        Station B1 = new Station("B1", line2);
        Station B2 = new Station("B2", line2);
        Station B3 = new Station("B3", line2);
        Station B4 = new Station("B4", line2);
        Station C1 = new Station("C1", line3);
        Station C2 = new Station("C2", line3);

        line1.addStation(A1);
        line1.addStation(A2);
        line2.addStation(B1);
        line2.addStation(B2);
        line2.addStation(B3);
        line2.addStation(B4);
        line3.addStation(C1);
        line3.addStation(C2);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(A1);
        stationIndex.addStation(A2);
        stationIndex.addStation(B1);
        stationIndex.addStation(B2);
        stationIndex.addStation(B3);
        stationIndex.addStation(B4);
        stationIndex.addStation(C1);
        stationIndex.addStation(C2);

        List<Station> connectionA2B2 = new ArrayList<>();
        connectionA2B2.add(A2);
        connectionA2B2.add(B2);
        stationIndex.addConnection(connectionA2B2);

        List<Station> connectionC2B4 = new ArrayList<>();
        connectionC2B4.add(C2);
        connectionC2B4.add(B4);
        stationIndex.addConnection(connectionC2B4);
    }

    public void testCalculateDuration() {
        route.add(stationIndex.getStation("A1"));
        route.add(stationIndex.getStation("A2"));
        route.add(stationIndex.getStation("B2"));
        route.add(stationIndex.getStation("B3"));
        route.add(stationIndex.getStation("B4"));
        route.add(stationIndex.getStation("C2"));
        route.add(stationIndex.getStation("C1"));

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("A1"), stationIndex.getStation("C1"));
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("A1"));
        expected.add(stationIndex.getStation("A2"));
        expected.add(stationIndex.getStation("B2"));
        expected.add(stationIndex.getStation("B3"));
        expected.add(stationIndex.getStation("B4"));
        expected.add(stationIndex.getStation("C2"));
        expected.add(stationIndex.getStation("C1"));

        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("B1"), stationIndex.getStation("B4"));
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("B1"));
        expected.add(stationIndex.getStation("B2"));
        expected.add(stationIndex.getStation("B3"));
        expected.add(stationIndex.getStation("B4"));

        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("B1"), stationIndex.getStation("C1"));
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("B1"));
        expected.add(stationIndex.getStation("B2"));
        expected.add(stationIndex.getStation("B3"));
        expected.add(stationIndex.getStation("B4"));
        expected.add(stationIndex.getStation("C2"));
        expected.add(stationIndex.getStation("C1"));

        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("A1"), stationIndex.getStation("C1"));
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("A1"));
        expected.add(stationIndex.getStation("A2"));
        expected.add(stationIndex.getStation("B2"));
        expected.add(stationIndex.getStation("B3"));
        expected.add(stationIndex.getStation("B4"));
        expected.add(stationIndex.getStation("C2"));
        expected.add(stationIndex.getStation("C1"));

        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
