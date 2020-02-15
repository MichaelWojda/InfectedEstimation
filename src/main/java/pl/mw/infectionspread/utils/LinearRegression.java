package pl.mw.infectionspread.utils;

import pl.mw.infectionspread.model.Data;
import pl.mw.infectionspread.model.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinearRegression {

    private Map<Integer, Integer> map = new HashMap<>();
    private double slope = 0;
    private double intercept = 0;


    public Result calulate(int X, List<Data> dataList) {
        double sumX = 0, sumY = 0, sumXY = 0, sumSqrX = 0;
        int n = dataList.size();
        for (int i = 0; i < n; i++) {
            sumX = sumX + dataList.get(i).getTimeDiff();
            sumY = sumY + dataList.get(i).getInfected();
            sumXY = sumXY + (dataList.get(i).getTimeDiff() * dataList.get(i).getInfected());
            sumSqrX = sumSqrX + Math.pow(dataList.get(i).getTimeDiff(), 2);

            //filling in map with real observations
            this.map.put(dataList.get(i).getTimeDiff(), dataList.get(i).getInfected());

        }
        slope = (n * sumXY - sumX * sumY) / (n * sumSqrX - Math.pow(sumX, 2));
        intercept = 1 / n * (sumY - slope * sumX);


        if (intercept == 0) {
            slope = sumXY / sumSqrX;
        }

        int result = (int) (slope * X + intercept);


        //filling in map of estimated observations
        for (int i = n; i <= X; i++) {
            map.put(i, (int)(slope * i + intercept));
        }


        return new Result(intercept, slope, result);


    }

    public Map<Integer, Integer> getMap() {

        return this.map;

    }




}
