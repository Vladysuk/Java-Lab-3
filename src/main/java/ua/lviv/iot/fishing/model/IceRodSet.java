package ua.lviv.iot.fishing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"iceRodSet\"")
public class IceRodSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "iceRodSet", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("iceRodSet")
    private Set<IceRod> iceRods;

    private String name;
    private Integer price;

    public IceRodSet(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public IceRodSet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<IceRod> getIceRods() {
        return iceRods;
    }

    public void setIceRods(Set<IceRod> iceRods) {
        this.iceRods = iceRods;
    }

}

