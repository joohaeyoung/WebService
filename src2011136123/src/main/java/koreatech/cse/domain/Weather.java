package koreatech.cse.domain;

public class Weather {
    private int id;
    private String icon;
    private String title;
    private String fcttext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() { return icon; }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFcttext() {
        return fcttext;
    }

    public void setFcttext(String fcttext) {
        this.fcttext = fcttext;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", fcttext='" + fcttext + '\'' +
                '}';
    }
}
