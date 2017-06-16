package com.example.coordinate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public final class User {

    @Id
    private ObjectId id;
    private String name;
    private List<Coordinate> coordinate;

    public User() {
    }

    public User(String name) {
        this.id = ObjectId.get();
        this.name = name;
        this.coordinate = new ArrayList<>();
    }

    public User(String name, Coordinate coordinate) {
        this(name);
        this.coordinate.add(coordinate);
    }

    public void addCoordinate(Coordinate coordinate) {
        this.coordinate.add(coordinate);
    }

//    public void addCoordinates(List<Coordinate> coordinates) {
//        this.coordinate.addAll(coordinates);
//    }


    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }


    public List<Coordinate> getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return coordinate != null ? coordinate.equals(user.coordinate) : user.coordinate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (coordinate != null ? coordinate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
