package ua.lviv.iot.fishing.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class IceRodShop {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "iceRodShops", joinColumns = {@JoinColumn(name = "shop_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "iceRod_id", nullable = false)})
    @JsonIgnoreProperties("iceRodShops")
    private Set<IceRod> iceRods;

    private String shopName;
    private String locationInTown;


    public IceRodShop(String shopName, String locationInTown) {
        this.shopName = shopName;
        this.locationInTown = locationInTown;
    }

    public IceRodShop() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLocationInTown() {
        return locationInTown;
    }

    public void setLocationInTown(String locationInTown) {
        this.locationInTown = locationInTown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<IceRod> getIceRods() {
        return iceRods;
    }

    public void setIceRods(Set<IceRod> iceRods) {
        this.iceRods = iceRods;
    }

}
