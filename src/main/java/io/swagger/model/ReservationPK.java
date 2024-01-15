package io.swagger.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationPK
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-11T08:59:36.048365385Z[GMT]")


public class ReservationPK   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("jmbg")
  private String jmbg = null;

  @JsonProperty("dateFrom")
  private Date dateFrom = null;

  @JsonProperty("dateTo")
  private Date dateTo = null;

  public ReservationPK id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ReservationPK jmbg(String jmbg) {
    this.jmbg = jmbg;
    return this;
  }

  /**
   * Get jmbg
   * @return jmbg
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getJmbg() {
    return jmbg;
  }

  public void setJmbg(String jmbg) {
    this.jmbg = jmbg;
  }

  public ReservationPK dateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;
  }

  /**
   * Get dateFrom
   * @return dateFrom
   **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
  public Date getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom) {
    this.dateFrom = dateFrom;
  }

  public ReservationPK dateTo(Date dateTo) {
    this.dateTo = dateTo;
    return this;
  }

  /**
   * Get dateTo
   * @return dateTo
   **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
  public Date getDateTo() {
    return dateTo;
  }

  public void setDateTo(Date dateTo) {
    this.dateTo = dateTo;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationPK reservationPK = (ReservationPK) o;
    return Objects.equals(this.id, reservationPK.id) &&
        Objects.equals(this.jmbg, reservationPK.jmbg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, jmbg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationPK {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    jmbg: ").append(toIndentedString(jmbg)).append("\n");
    sb.append("    dateFrom: ").append(toIndentedString(dateFrom)).append("\n");
    sb.append("    dateTo: ").append(toIndentedString(dateTo)).append("\n");
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
