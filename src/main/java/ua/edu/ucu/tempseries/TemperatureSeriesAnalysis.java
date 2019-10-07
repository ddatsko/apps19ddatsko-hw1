package ua.edu.ucu.tempseries;

import jdk.nashorn.internal.objects.annotations.Function;
import jdk.nashorn.internal.runtime.FunctionInitializer;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class TemperatureSeriesAnalysis {

    private double[] temperatures;
    private int capacity;
    private int temperaturesNum;

    public TemperatureSeriesAnalysis() {
        temperatures = new double[1];
        capacity = 1;
        temperaturesNum = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temperatures = temperatureSeries;
        capacity = temperatures.length;
        temperaturesNum = capacity;
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
        for (double temperature : temperatures)
            m = Math.max(temperature, m);
        return m;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatures.length == 0)
            throw new IllegalArgumentException();

        double closest_temp = temperatures[0];
        double current_closest = abs(temperatures[0] - tempValue);
        for (double temperature : temperatures) {
            if (current_closest == abs(temperature - tempValue) && temperature > tempValue)
                closest_temp = temperature;
            else if (current_closest > abs(temperature - tempValue)) {
                current_closest = abs(temperature - tempValue);
                closest_temp = temperature;
            }
        }
        return closest_temp;
    }


    private double[] findTempsWithCondition(boolean greater, double tempValue) {
        TemperatureSeriesAnalysis tempsLess = new TemperatureSeriesAnalysis();
        for (double temperature : temperatures)
            if ((temperature > tempValue && greater) || (temperature < tempValue && !greater))
                tempsLess.addTemps(temperature);
        return tempsLess.temperatures;
    }

    public double[] findTempsLessThen(double tempValue) {
        return findTempsWithCondition(false, tempValue);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findTempsWithCondition(true, tempValue);
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
