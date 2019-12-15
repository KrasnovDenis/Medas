package nc.Medas.ModelDetails;

public class ScheduleDetails {

    private String Filmtitle;
    private double FilmDuration;
    private String FilmPoster;
    private double FilmRating;
    private String HallTitle;
    private String ScreenDateTime;
    private int ScreenPrice;
    private int idHall;
    private int idScreen;

    public int getIdHall() {
        return idHall;
    }

    public int getIdScreen() {
        return idScreen;
    }

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


    public ScheduleDetails(ScheduleBuilder builder) {
        this.FilmDuration = builder.FilmDuration;
        this.FilmPoster = builder.FilmPoster;
        this.FilmRating = builder.FilmRating;
        this.HallTitle = builder.HallTitle;
        this.ScreenDateTime = builder.ScreenDateTime;
        this.ScreenPrice = builder.ScreenPrice;
        this.Filmtitle = builder.FilmTitle;
        this.idHall = builder.idHall;
        this.idScreen = builder.idScreen;

    }

    public static class ScheduleBuilder {
        private String FilmTitle;

        private double FilmDuration;
        private String FilmPoster;
        private double FilmRating;
        private String HallTitle;
        private String ScreenDateTime;
        private int ScreenPrice;
        private int idHall;
        private int idScreen;

        public ScheduleBuilder() {

        }

        public ScheduleBuilder setIdHall(int idHall) {
            this.idHall = idHall;
            return this;
        }

        public ScheduleBuilder setIdScreen(int idScreen) {
            this.idScreen = idScreen;
            return this;
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

        public ScheduleDetails build() {
            return new ScheduleDetails(this);
        }
    }

}