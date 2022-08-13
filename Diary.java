
class Diary {
    private String date;
    public String year;
    public String month;
    public String day;
    private String title;
    private String content;
    private String access;
    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;

    }

}