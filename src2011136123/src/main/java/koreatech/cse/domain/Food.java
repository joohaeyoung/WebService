package koreatech.cse.domain;

public class Food {

    private static Food instance;
    private Food(){}//객체 생성을 막는다.
    public static synchronized Food getInstance(){

        if( instance == null )
            instance = new Food();

        return instance;
    }

    private int id;
    private  String shname;
    private String shinfo;
    private String shpride;
    private  String shaddr;

    public int getId() {
        return id;
    }

    public Food setId(int id) {
        this.id = id;
        return this;
    }

    public static void setInstance(Food instance) {
        Food.instance = instance;
    }

    public String getShname() {
        return shname;
    }

    public Food setShname(String shname) {
        this.shname = shname;
        return this;
    }

    public String getShinfo() {
        return shinfo;
    }

    public Food setShinfo(String shinfo) {
        this.shinfo = shinfo;
        return this;
    }

    public String getShpride() {
        return shpride;
    }

    public Food setShpride(String shpride) {
        this.shpride = shpride;
        return this;
    }

    public String getShaddr() {
        return shaddr;
    }

    public Food setShaddr(String shaddr) {
        this.shaddr = shaddr;
        return this;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", shname='" + shname + '\'' +
                ", shinfo='" + shinfo + '\'' +
                ", shpride='" + shpride + '\'' +
                ", shaddr='" + shaddr + '\'' +
                '}';
    }
}
