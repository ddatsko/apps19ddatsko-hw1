package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {
    @Test
    public void testClosestToValueOneClosestElement() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(4.0);
        assertEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testClosestToValueTwoOppositeElements() {
        double[] temperatureSeries = {1.0, 3.0, 4.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(2.0);
        assertEquals(expResult, actualResult, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToValue(0.0);
    }

    @Test
    public void testClosestToZeroOeClosestElement() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testClosestToZeroTwoOppositeElements() {
        double[] temperatureSeries = {2.0, -2.0, -1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testMinValueNormalArray() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testMinValueSameElementsArray() {
        double[] temperatureSeries = {1.0, 1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.min();
    }

    @Test
    public void testMaxValueNormalArray() {
        double[] temperatureSeries = {1.0, 2.0, 3.0, 0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testMaxValueSameElementsArray() {
        double[] temperatureSeries = {1.0, 1.0, 1.0, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actualResult = seriesAnalysis.max();
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }


}
