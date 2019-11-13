package model;

public class Horse {

    private String id;
    private String name;
    private String breed;
    private int yearOfBirth;
    private String countryOfOrigin;
    private String sex;
    private String gait;
    private String raceType;
    private String comment;
    private String sireName;
    private String damName;

    public Horse(String id, String name, String breed, int yearOfBirth, String countryOfOrigin, String sex, String gait, String raceType, String comment, String sireName, String damName) {
        this.name = name;
        this.id = id;
        this.breed = breed;
        this.yearOfBirth = yearOfBirth;
        this.countryOfOrigin = countryOfOrigin;
        this.sex = sex;
        this.gait = gait;
        this.raceType = raceType;
        this.comment = comment;
        this.sireName = sireName;
        this.damName = damName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGait() {
        return gait;
    }

    public void setGait(String gait) {
        this.gait = gait;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSireName() {
        return sireName;
    }

    public void setSireName(String sireName) {
        this.sireName = sireName;
    }

    public String getDamName() {
        return damName;
    }

    public void setDamName(String damName) {
        this.damName = damName;
    }
}