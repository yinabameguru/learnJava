public class DistanceTest {

    private static final double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double long1, double lat1, double long2, double lat2) {
        double a, b, d, sa2, sb2;
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        a = lat1 - lat2;
        b = rad(long1 - long2);

        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * EARTH_RADIUS
            * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
            * Math.cos(lat2) * sb2 * sb2)) * 1000 ;
        return d;
    }

    public static void main(String[] args) {
        Double distance = getDistance(31.6122990000000000, 120.2431810000000000,
            31.5521080000000000,
            120.3237830000000000);
        System.out.println(distance);
        System.out.println(Math.round(distance));
    }
}
