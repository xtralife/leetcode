package com.github.xtralife.pramp.htree;

public class Main {
    static public void main(String[] args) {
        System.out.println("Practice makes Perfect!");
        drawHTree(0, 0, 4, 3);
    }

    public static void drawHTree(double x, double y, double length, double depth) {
        if (depth == 0) {
            return;
        }

        double halfLength = length / 2;
        double leftX = x - halfLength;
        double rightX = x + halfLength;
        double topY = y + halfLength;
        double bottomY = y + halfLength;
        drawLine(leftX, y, rightX, y);
        drawLine(leftX, topY, leftX, bottomY);
        drawLine(rightX, topY, rightX, bottomY);

        double newLength = length / Math.sqrt(2);
        drawHTree(leftX, topY, newLength, depth - 1);
        drawHTree(leftX, bottomY, newLength, depth - 1);
        drawHTree(rightX, topY, newLength, depth - 1);
        drawHTree(rightX, bottomY, newLength, depth - 1);
    }

    private static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.printf("Drawing a line from [%12.2f, %12.2f] to [%12.2f, %12.2f]%n", x1, y1, x2, y2);
    }
}
