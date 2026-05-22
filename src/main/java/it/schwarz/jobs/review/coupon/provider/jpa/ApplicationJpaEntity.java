package it.schwarz.jobs.review.coupon.provider.jpa;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "APPLICATION", indexes = @Index(name = "idx_application_coupon_code", columnList = "COUPON_CODE"))
public class ApplicationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUPON_CODE", nullable = false)
    private CouponJpaEntity coupon;

    @Column(name = "TIMESTAMP", nullable = false)
    private Instant timestamp;


    public ApplicationJpaEntity() {
    }

    public ApplicationJpaEntity(CouponJpaEntity coupon, Instant timestamp) {
        this.coupon = coupon;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public String getCouponCode() {
        return coupon.getCode();
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
