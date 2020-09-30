package com.xgf.correlation.one_to_one.bean;

/*person表
* 关联card表，id_card（外键） --> 关联card表的id
*   person表关联card表，成员变量card
* */
public class Person {

    private Integer id;
    private String username;
    private Card card; // 1	111111111123456789

    public Person() {
    }

    public Person(Integer id, String username, Card card) {
        this.id = id;
        this.username = username;
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", card=" + card +
                '}';
    }
}
