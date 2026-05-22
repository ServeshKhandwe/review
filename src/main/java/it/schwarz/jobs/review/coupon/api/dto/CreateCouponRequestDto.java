package it.schwarz.jobs.review.coupon.api.dto;

import it.schwarz.jobs.review.coupon.domain.entity.AmountOfMoney;
import it.schwarz.jobs.review.coupon.domain.entity.Coupon;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateCouponRequestDto(

        @NotNull
        @Size(min = 1, max = 20)
        String code,

        @NotNull
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "10000.00")
        BigDecimal discount,

        @NotNull
        @DecimalMin(value = "0.00")
        @DecimalMax(value = "10000.00")
        BigDecimal minBasketValue,

        @NotNull
        @Size(min = 1, max = 1000)
        String description) {

    public Coupon toCoupon() {
        return new Coupon(
                code,
                AmountOfMoney.of(discount),
                AmountOfMoney.of(minBasketValue),
                description
        );
    }
}
