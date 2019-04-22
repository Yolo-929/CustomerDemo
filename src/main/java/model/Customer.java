package model;

import java.util.Date;

public class Customer {
    private String id;
    private String name ;
    private String gender ;
    private Date birthday ;
    private String cellphone ;
    private String eamil ;
    private String preference ;
    private String type ;
    private String description;

    public Customer() {
    }

    public Customer(String id, String name, String gender, Date birthday, String cellphone, String eamil, String preference, String type, String description) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.cellphone = cellphone;
        this.eamil = eamil;
        this.preference = preference;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
