package nc.Medas.service;

import java.util.Date;

public class Schedule {

    private String Filmtitle;
    private double FilmDuration;
    private String FilmPoster;
    private double FilmRating;
    private String HallTitle;
    private String ScreenDateTime;
    private int ScreenPrice;

    public double getFilmDuration() {
        return FilmDuration;
    }

    public String getFilmPoster() {
        return FilmPoster;
    }

    public double getFilmRating() {
        return FilmRating;
    }

    public String getHallTitle() {
        return HallTitle;
    }

    public String getFilmtitle() {
        return Filmtitle;
    }

    public String getScreenDateTime() {
        return ScreenDateTime;
    }

    public int getScreenPrice() {
        return ScreenPrice;
    }


    public Schedule (ScheduleBuilder builder) {
        this.FilmDuration =builder.FilmDuration;
        this.FilmPoster= builder.FilmPoster;
        this.FilmRating = builder.FilmRating;
        this.HallTitle = builder.HallTitle;
        this.ScreenDateTime = builder.ScreenDateTime;
        this.ScreenPrice = builder.ScreenPrice;
        this.Filmtitle = builder.FilmTitle;

    }

    public static class ScheduleBuilder {
        private String FilmTitle;

        private double FilmDuration;
        private String FilmPoster;
        private double FilmRating;
        private String HallTitle;
        private String ScreenDateTime;
        private int ScreenPrice;


        ScheduleBuilder() {

        }

        public ScheduleBuilder setFilmDuration(double filmDuration) {
            FilmDuration = filmDuration;
            return this;
        }

        public ScheduleBuilder setFilmPoster(String filmPoster) {
            FilmPoster = filmPoster;
            return this;
        }

        public ScheduleBuilder setFilmRating(double filmRating) {
            FilmRating = filmRating;
            return this;
        }


        public ScheduleBuilder setFilmTitle(String filmTitle) {
            FilmTitle = filmTitle;
            return this;
        }

        public ScheduleBuilder setHallTitle(String hallTitle) {
            HallTitle = hallTitle;
            return this;
        }

        public ScheduleBuilder setScreenDateTime(String screenDateTime) {
            ScreenDateTime = screenDateTime;
            return this;
        }

        public ScheduleBuilder setScreenPrice(int screenPrice) {
            ScreenPrice = screenPrice;
            return this;
        }

        public Schedule build(){
            return new Schedule(this);
        }
    }

}