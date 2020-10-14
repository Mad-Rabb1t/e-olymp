package solutions.p8637;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SortThePoints {
    static class CustomComp implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            return ((p1.x + p1.y) == (p2.x + p2.y)) ? (p1.x - p2.x) : ((p1.x + p1.y) - (p2.x + p2.y));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        while (in.hasNext()) {
            points.add(new Point(in.nextInt(), in.nextInt()));
        }

        points.sort(new CustomComp());
        points.forEach(p -> System.out.printf("%d %d\n", p.x, p.y));
    }
}
