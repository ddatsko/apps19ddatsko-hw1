package ua.edu.ucu.tempseries;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class TemperatureSeriesAnalysis {

    private double[] temperatures;

    public TemperatureSeriesAnalysis() {
        temperatures = new double[0];

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatures = temperatureSeries;
    }

    public double average() {
        if (temperatures.length == 0)
            throw new IllegalArgumentException();
        double sum = 0;
        for (double temperature : temperatures) {
            sum += temperature;
        }
        return sum / temperatures.length;
    }

    public double deviation() {
        double mean = average();
        double quadraticSum = 0;
        for (double temperature : temperatures) {
            quadraticSum += pow(abs(temperature - mean), 2);
        }
        return quadraticSum / temperatures.length;
    }

    public double min() {
        if (temperatures.length == 0)
            throw new IllegalArgumentException();
        double m = temperatures[0];
        for (double temperature : temperatures)
            m = Math.min(m, temperature);
        return m;
    }

    public double max() {
        if (temperatures.length == 0)
            throw new IllegalArgumentException();
        double m = temperatures[0];
        for (double temperature: temperatures)
            m = Math.max(temperature, m);
        return m;
    }

    public double findTempClosestToZero() {
        if (temperatures.length == 0)
            throw new IllegalArgumentException();

        double closest_temp = 0;
        double current_closest = abs(temperatures[0]);
        for (double temperature : temperatures){
            if (current_closest == abs(temperature) && temperature > 0)
                closest_temp = temperature;
            else if (current_closest > abs(temperature)) {
                current_closest = abs(temperature);
                closest_temp = temperature;
            }
        }
        return closest_temp;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
