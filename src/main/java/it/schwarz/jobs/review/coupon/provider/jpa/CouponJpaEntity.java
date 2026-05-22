package it.schwarz.jobs.review.coupon.provider.jpa;


import jakarta.persistence.*;
import org.springframework.data.domain.Persistable;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "COUPON")
public class CouponJpaEntity implements Persistable<String> {

    @Id
    @Column(name = "CODE", nullable = false)
    private String code;
    @Column(name = "DISCOUNT", nullable = false, precision = 10, scale = 2)
    private BigDecimal discount;
    @Column(name = "MIN_BASKET_VALUE", nullable = false, precision = 10, scale = 2)
    private BigDecimal minBasketValue;
    @Column(name = "DESCRIPTION", nullable = false, length = 1000)
    private String description;
    @OneToMany(mappedBy = "coupon", fetch = FetchType.LAZY)
    private List<ApplicationJpaEntity> applications;

    // Tells Spring Data this entity is always new — forces persist() over merge()
    // Required because the ID is user-provided (not auto-generated), so Spring Data
    @Transient
    private boolean isNew = true;

    public CouponJpaEntity() {
    }

    public CouponJpaEntity(String code, BigDecimal discount, String description, BigDecimal minBasketValue) {
        this.code = code;
        this.discount = discount;
        this.description = description;
        this.minBasketValue = minBasketValue;
    }

    @Override
    public String getId() {
        return code;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getMinBasketValue() {
        return minBasketValue;
    }

    public String getDescription() {
        return description;
    }

    public List<ApplicationJpaEntity> getApplications() {
        return applications;
    }
}
