package org.quarkus.sample.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDTO {

  @NotNull
  private String author;

  @Max(20)
  private String descriptioin;

  @NotBlank
  private String name;

  @Max(99)
  @Min(0)
  private Integer status;

  public String getDescriptioin() {
    return descriptioin;
  }

  public void setDescriptioin(String descriptioin) {
    this.descriptioin = descriptioin;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
