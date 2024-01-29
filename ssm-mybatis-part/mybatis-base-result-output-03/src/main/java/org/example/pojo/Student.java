package org.example.pojo;

public class Student {

    private Integer sid;

    private String snmae;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSnmae() {
        return snmae;
    }

    public void setSnmae(String snmae) {
        this.snmae = snmae;
    }

    @Override
    public String  toString() {
        return "Student{" +
                "sid=" + sid +
                ", snmae='" + snmae + '\'' +
                '}';
    }
}
