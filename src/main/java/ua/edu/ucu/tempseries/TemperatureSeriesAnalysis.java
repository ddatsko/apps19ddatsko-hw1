package ua.edu.ucu.tempseries;

import jdk.nashorn.internal.objects.annotations.Function;
import jdk.nashorn.internal.runtime.FunctionInitializer;

import java.util.InputMismatchException;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class TemperatureSeriesAnalysis {

    public double[] getTemperatures() {
        return temperatures;
    }

    private double[] temperatures;
    private int capacity;
    private int temperaturesNum;

    public TemperatureSeriesAnalysis() {
        temperatures = new double[1];
        capacity = 1;
        temperaturesNum = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this();
        for (double temperature : temperatureSeries) {
            if (temperature < -273)
                throw new InputMismatchException();
        }
        temperatures = temperatureSeries;
        capacity = temperatures.length;
        temperaturesNum = capacity;
    }

    public double average() {
        if (temperaturesNum == 0)
            throw new IllegalArgumentException();
        double sum = 0;
        for (int i = 0; i < temperaturesNum; i++) {
            sum += temperatures[i];
        }
        return sum / temperaturesNum;
    }


    public double deviation() {
        double mean = average();
        double quadraticSum = 0;
        for (int i = 0; i < temperaturesNum; i++) {
            quadraticSum += pow(abs(temperatures[i] - mean), 2);
        }
        return quadraticSum / temperaturesNum;
    }

    public double min() {
        if (temperaturesNum == 0)
            throw new IllegalArgumentException();
        double m = temperatures[0];
        for (int i = 0; i < temperaturesNum; i++)
            m = Math.min(m, temperatures[i]);
        return m;
    }

    public double max() {
        if (temperaturesNum == 0)
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
        if (temperaturesNum == 0)
            throw new IllegalArgumentException();

        double closest_temp = temperatures[0];
        double current_closest = abs(temperatures[0] - tempValue);
        for (int i = 0; i < temperaturesNum; i++) {
            if (current_closest == abs(temperatures[i] - tempValue) && temperatures[i] > tempValue)
                closest_temp = temperatures[i];
            else if (current_closest > abs(temperatures[i] - tempValue)) {
                current_closest = abs(temperatures[i] - tempValue);
                closest_temp = temperatures[i];
            }
        }
        return closest_temp;
    }


    private double[] findTempsWithCondition(boolean greater, double tempValue) {
        TemperatureSeriesAnalysis tempsLess = new TemperatureSeriesAnalysis();
        for (int i = 0; i < temperaturesNum; i++)
            if ((temperatures[i] > tempValue && greater) || (temperatures[i] < tempValue && !greater))
                tempsLess.addTemps(temperatures[i]);
        double[] res = new double[tempsLess.temperaturesNum];
        System.arraycopy(tempsLess.temperatures, 0, res, 0, res.length);
        return res;
    }

    public double[] findTempsLessThan(double tempValue) {
        return findTempsWithCondition(false, tempValue);
    }

    public double[] findTempsGreaterThan(double tempValue) {
        return findTempsWithCondition(true, tempValue);
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    private void addOneTemp(double temp) {
        if (capacity == temperaturesNum) {
            double[] newArr = new double[capacity * 2];
            System.arraycopy(temperatures, 0, newArr, 0, temperaturesNum);
            temperatures = newArr;
            capacity *= 2;
        }
        temperatures[temperaturesNum] = temp;
        temperaturesNum++;
    }

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < -273)
                throw new InputMismatchException();
        }
        for (double temp : temps) {
            addOneTemp(temp);
        }
        return temperaturesNum;
    }
}
