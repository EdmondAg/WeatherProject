package org.example.repository;

import jakarta.persistence.*;

@Entity
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "city_id", nullable = false)
    private int cityId;
    @Basic
    @Column(name = "name", nullable = true, length = 35)
    private String name;
    @Basic
    @Column(name = "country", nullable = true, length = 35)
    private String country;
    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    private Double latitude;
    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    private Double longitude;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityId != city.cityId) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (country != null ? !country.equals(city.country) : city.country != null) return false;
        if (latitude != null ? !latitude.equals(city.latitude) : city.latitude != null) return false;
        if (longitude != null ? !longitude.equals(city.longitude) : city.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
