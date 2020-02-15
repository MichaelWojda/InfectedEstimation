package pl.mw.infectionspread.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mw.infectionspread.model.Data;
import pl.mw.infectionspread.model.Result;
import pl.mw.infectionspread.repositories.DataRepository;
import pl.mw.infectionspread.utils.LinearRegression;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class HomeController {


    DataRepository dataRepository;

    @Autowired
    public HomeController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/calculate")
    public String resultPage(@RequestParam String date, Model model){
        //calculating difference between day 0 and searched date
        LocalDate requestedDate = LocalDate.parse(date);
        LocalDate beginning = LocalDate.of(2020,1,23);
        int X = (int) DAYS.between(beginning,requestedDate);
        //getting data from DB and putting it into the Linear Regression Class
        List<Data> list = dataRepository.findAll();
        LinearRegression linearRegression = new LinearRegression();
        //Getting result and map
        Result result = linearRegression.calulate(X,list);
        Map<Integer,Integer> newMap = linearRegression.getMap();
        //Getting ponits for regression line
        int x0=0;
        int y0=845;
        int xf=X;
        int yf= (int) result.getEstimatedValue();
        //Adding attributes
        model.addAttribute("result",result);
        model.addAttribute("map",newMap);
        model.addAttribute("x0",x0);
        model.addAttribute("y0",y0);
        model.addAttribute("xf",xf);
        model.addAttribute("yf",yf);


        return "resultpage";



    }


}
