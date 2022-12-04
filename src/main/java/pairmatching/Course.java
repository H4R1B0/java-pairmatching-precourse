package pairmatching;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String course;

    Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
