package Exercise2;

import java.util.Date;

public class JobPosition {

    private final Date publishDate;
    private final String title;
    private String description;
    private Location location;
    private double salaryCap;
    private final boolean isRemote;
    private double yearsOfExperience;

    public static class Builder {

        private final Date publishDate;
        private final String title;
        private String description;
        private Location location = Location.TEL_AVIV;
        private double salaryCap;
        private final boolean isRemote;
        private double yearsOfExperience;

        public Builder(Date publishDate, String title, boolean isRemote) {
            this.publishDate = publishDate;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(double salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public Builder yearsOfExperience(double yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    private JobPosition(Builder builder) {
        this.publishDate = builder.publishDate;
        this.title = builder.title;
        this.description = builder.description;
        this.location = builder.location;
        this.salaryCap = builder.salaryCap;
        this.isRemote = builder.isRemote;
        this.yearsOfExperience = builder.yearsOfExperience;
    }
}
