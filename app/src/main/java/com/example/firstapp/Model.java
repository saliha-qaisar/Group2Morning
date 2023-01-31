package com.example.firstapp;

public class Model {
    private String date;

    private String prayed;
    private String rakat;
    private String jamat;

    @Override
    public String toString() {
        return "Model{" +
                "date='" + date + '\'' +
                ", prayed='" + prayed + '\'' +
                ", rakat='" + rakat + '\'' +
                ", jamat='" + jamat + '\'' +
                ", prayer='" + prayer + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrayed() {
        return prayed;
    }

    public void setPrayed(String prayed) {
        this.prayed = prayed;
    }

    public String getRakat() {
        return rakat;
    }

    public void setRakat(String rakat) {
        this.rakat = rakat;
    }

    public String getJamat() {
        return jamat;
    }

    public void setJamat(String jamat) {
        this.jamat = jamat;
    }

    public String getPrayer() {
        return prayer;
    }

    public void setPrayer(String prayer) {
        this.prayer = prayer;
    }

    public  Model()
    {

    }

    public Model(String date, String prayed, String rakat, String jamat, String prayer) {
        this.date = date;
        this.prayed = prayed;
        this.rakat = rakat;
        this.jamat = jamat;
        this.prayer = prayer;
    }

    private String prayer;
}
