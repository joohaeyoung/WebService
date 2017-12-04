package koreatech.cse.domain;



public class Concert {

    private static Concert instance;
    private Concert(){}//객체 생성을 막는다.
    public static synchronized Concert getInstance(){

        if( instance == null )
            instance = new Concert();

        return instance;
    }

    private int id;
    private  String title;
    private String startdate;
    private String enddate;
    private  String place;

    public int getId() {
        return id;
    }

    public Concert setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Concert setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStartdate() {
        return startdate;
    }

    public Concert setStartdate(String startdate) {
        this.startdate = startdate;
        return this;
    }

    public String getEnddate() {
        return enddate;
    }

    public Concert setEnddate(String enddate) {
        this.enddate = enddate;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Concert setPlace(String place) {
        this.place = place;
        return this;
    }
}
