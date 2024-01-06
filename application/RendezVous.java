package application;
import java.util.Date;

public class RendezVous {
    private Date date;
    private String lieu;
    public RendezVous(Date date, String lieu) {
        this.date = date;
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

}
