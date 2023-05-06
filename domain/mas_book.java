package kcsj.domain;

public class mas_book {
    private String book_no;

    private String book_name;

    private String book_publisher;

    private String book_date;

    private int book_distribute;

    private byte[] book_identity;

    public String getBook_first() {
        return book_first;
    }

    public void setBook_first(String book_first) {
        this.book_first = book_first;
    }

    public String getBook_last() {
        return book_last;
    }

    public void setBook_last(String book_last) {
        this.book_last = book_last;
    }

    private String book_first;
    private String book_last;

    public mas_book() {// 无参构造器
    }

    public String getBook_no() {
        return book_no;
    }

    public void setBook_no(String book_no) {
        this.book_no = book_no;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public String getBook_date() {
        return book_date;
    }

    public void setBook_date(String book_date) {
        this.book_date = book_date;
    }

    public int getBook_distribute() {
        return book_distribute;
    }

    public void setBook_distribute(int book_distribute) {
        this.book_distribute = book_distribute;
    }

    public byte[] getBook_identity() {
        return book_identity;
    }

    public void setBook_identity(byte[] book_identity) {
        this.book_identity = book_identity;
    }

    @Override
    public String toString() {
        return "教材表{" +
                "教材编号='" + book_no + '\'' +
                ", 教材名称='" + book_name + '\'' +
                ", 出版社='" + book_publisher + '\'' +
                ", 出版时间='" + book_date + '\'' +
                ", 对教材贡献度=" + book_distribute +
                ", 初审结果='" + book_first + '\'' +
                ", 终审结果='" + book_last + '\'' +
                '}';
    }

}
