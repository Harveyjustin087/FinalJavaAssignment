package Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "hr", catalog = "")
public class CountriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private String countryId;
    @Basic
    @Column(name = "country_name")
    private String countryName;
    @Basic
    @Column(name = "region_id")
    private int regionId;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id", nullable = false, insertable = false, updatable = false)
    private RegionsEntity regionsByRegionId;
    @OneToMany(mappedBy = "countriesByCountryId")
    private Collection<LocationsEntity> locationsByCountryId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return regionId == that.regionId && Objects.equals(countryId, that.countryId) && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName, regionId);
    }

    public RegionsEntity getRegionsByRegionId() {
        return regionsByRegionId;
    }

    public void setRegionsByRegionId(RegionsEntity regionsByRegionId) {
        this.regionsByRegionId = regionsByRegionId;
    }

    public Collection<LocationsEntity> getLocationsByCountryId() {
        return locationsByCountryId;
    }

    public void setLocationsByCountryId(Collection<LocationsEntity> locationsByCountryId) {
        this.locationsByCountryId = locationsByCountryId;
    }
}
