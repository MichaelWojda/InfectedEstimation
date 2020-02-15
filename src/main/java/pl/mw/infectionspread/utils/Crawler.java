package pl.mw.infectionspread.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.mw.infectionspread.model.Data;
import pl.mw.infectionspread.repositories.DataRepository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class Crawler {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
    private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private static final String URL="https://www.worldometers.info/coronavirus/";

    @Autowired
    private DataRepository dataRepository;

   @Scheduled(cron="0 21 19 * * ?")
    public void simpleTask(){
       int data = crawl(URL);
       if(data!=0){
           Data inputData = new Data();
           int timeDiff = calculateTimeDifference();
           inputData.setDate(LocalDate.now());
           inputData.setInfected(data);
           inputData.setTimeDiff(timeDiff);
           dataRepository.save(inputData);
           System.out.println("Saved");

       }

    }



    private int crawl(String URL){

        Connection connection = Jsoup.connect(URL).userAgent(USER_AGENT);
        try {
            Document document = connection.get();
            Element searched = document.select("div.maincounter-number").first();
            String text = searched.select("span").text();
            text = text.replaceAll(",","");
            return Integer.parseInt(text);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;

    }

    private int calculateTimeDifference() {
        LocalDate today = LocalDate.now();
        LocalDate beginning = LocalDate.of(2020,1,23);
        return (int) DAYS.between(beginning,today);
    }
}
