package koreatech.cse.domain;

public class Deli {



    private static Deli instance;
    private Deli(){}//객체 생성을 막는다.
    public static synchronized Deli getInstance(){

        if( instance == null )
            instance = new Deli();

        return instance;
    }

    private int id;
    private  String cate2name;
    private String namekor;
    private String hkorgu;
    private  String hkordong;


    public static void setInstance(Deli instance) {
        Deli.instance = instance;
    }

    public int getId() {
        return id;
    }

    public Deli setId(int id) {
        this.id = id;
        return this;
    }

    public String getCate2name() {
        return cate2name;
    }

    public Deli setCate2name(String cate2name) {
        this.cate2name = cate2name;
        return this;
    }

    public String getNamekor() {
        return namekor;
    }

    public Deli setNamekor(String namekor) {
        this.namekor = namekor;
        return this;
    }

    public String getHkorgu() {
        return hkorgu;
    }

    public Deli setHkorgu(String hkorgu) {
        this.hkorgu = hkorgu;
        return this;
    }

    public String getHkordong() {
        return hkordong;
    }

    public Deli setHkordong(String hkordong) {
        this.hkordong = hkordong;
        return this;
    }


    @Override
    public String toString() {
        return "Deli{" +
                "id=" + id +
                ", cate3name='" + cate2name + '\'' +
                ", namekor='" + namekor + '\'' +
                ", hkorgu='" + hkorgu + '\'' +
                ", hkordong='" + hkordong + '\'' +
                '}';
    }
}