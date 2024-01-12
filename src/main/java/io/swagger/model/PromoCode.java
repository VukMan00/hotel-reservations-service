package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Guest;
import io.swagger.model.PromoCodePK;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PromoCode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-11T08:59:36.048365385Z[GMT]")
public class PromoCode   {
  @JsonProperty("promoCodePK")
  private PromoCodePK promoCodePK = null;

  @JsonProperty("discount")
  private Integer discount = null;

  @JsonProperty("used")
  private Boolean used = null;

  @JsonProperty("guest")
  private Guest guest = null;

  public PromoCode promoCodePK(PromoCodePK promoCodePK) {
    this.promoCodePK = promoCodePK;
    return this;
  }

  /**
   * Get promoCodePK
   * @return promoCodePK
   **/
  @Schema(description = "")
  
    @Valid
    public PromoCodePK getPromoCodePK() {
    return promoCodePK;
  }

  public void setPromoCodePK(PromoCodePK promoCodePK) {
    this.promoCodePK = promoCodePK;
  }

  public PromoCode discount(Integer discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public PromoCode used(Boolean used) {
    this.used = used;
    return this;
  }

  /**
   * Get used
   * @return used
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isUsed() {
    return used;
  }

  public void setUsed(Boolean used) {
    this.used = used;
  }

  public PromoCode guest(Guest guest) {
    this.guest = guest;
    return this;
  }

  /**
   * Get guest
   * @return guest
   **/
  @Schema(description = "")
  
    @Valid
    public Guest getGuest() {
    return guest;
  }

  public void setGuest(Guest guest) {
    this.guest = guest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromoCode promoCode = (PromoCode) o;
    return Objects.equals(this.promoCodePK, promoCode.promoCodePK) &&
        Objects.equals(this.discount, promoCode.discount) &&
        Objects.equals(this.used, promoCode.used);
  }

  @Override
  public int hashCode() {
    return Objects.hash(promoCodePK, discount, used);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PromoCode {\n");
    
    sb.append("    promoCodePK: ").append(toIndentedString(promoCodePK)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    used: ").append(toIndentedString(used)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
