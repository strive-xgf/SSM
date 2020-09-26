package com.xgf.correlation.one_to_one.bean;

/*身份证表*/
public class Card {

    private Integer id;
    private String code;

    public Card() {
    }

    public Card(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }
}
