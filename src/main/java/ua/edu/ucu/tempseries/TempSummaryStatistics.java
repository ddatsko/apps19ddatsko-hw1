package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    final private double avgTemp, devTemp, minTemp, maxTemp;

    TempSummaryStatistics(double avgTemp, double devTemp, double minTemp, double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    private boolean equalTemp(double temp1, double temp2) {
        return Math.abs(temp1 - temp2) < 1e-5;
    }

    boolean equals(TempSummaryStatistics other) {
        return equalTemp(avgTemp, other.getAvgTemp()) && equalTemp(devTemp, other.getDevTemp()) &&
                equalTemp(minTemp, other.getMinTemp()) && equalTemp(maxTemp, other.getMaxTemp());
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
