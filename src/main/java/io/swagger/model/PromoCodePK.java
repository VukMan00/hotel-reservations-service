package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * PromoCodePK
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-11T08:59:36.048365385Z[GMT]")
public class PromoCodePK   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("jmbg")
  private String jmbg = null;

  public PromoCodePK id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(required = true, description = "")

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PromoCodePK jmbg(String jmbg) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromoCodePK promoCodePK = (PromoCodePK) o;
    return Objects.equals(this.id, promoCodePK.id) &&
        Objects.equals(this.jmbg, promoCodePK.jmbg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, jmbg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PromoCodePK {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    jmbg: ").append(toIndentedString(jmbg)).append("\n");
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
