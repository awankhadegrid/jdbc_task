package org.jdbclearning;

public class User {
    int id;
    String name;
    String city;

    User(int id,String name,String city){
        this.id=id;
        this.name=name;
        this.city=city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}
