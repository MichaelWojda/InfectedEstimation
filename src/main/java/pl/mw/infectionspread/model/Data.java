package pl.mw.infectionspread.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_data;
    private LocalDate date;
    private int timeDiff;
    private int infected;

    public Integer getId_data() {
        return id_data;
    }

    public void setId_data(Integer id_data) {
        this.id_data = id_data;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(int timeDiff) {
        this.timeDiff = timeDiff;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }
}
