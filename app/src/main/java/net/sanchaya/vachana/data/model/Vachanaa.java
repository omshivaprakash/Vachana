package net.sanchaya.vachana.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vachanaa {

  @SerializedName("vachana") @Expose private Vachana vachana;

  /**
   * @return The vachana
   */
  public Vachana getVachana() {
    return vachana;
  }

  /**
   * @param vachana The vachana
   */
  public void setVachana(Vachana vachana) {
    this.vachana = vachana;
  }

  public class Vachana {

    @SerializedName("vachana") @Expose private String vachana;
    @SerializedName("vachanakaara") @Expose private Vachanakaara vachanakaara;

    /**
     * @return The vachana
     */
    public String getVachana() {
      return vachana;
    }

    /**
     * @param vachana The vachana
     */
    public void setVachana(String vachana) {
      this.vachana = vachana;
    }

    /**
     * @return The vachanakaara
     */
    public Vachanakaara getVachanakaara() {
      return vachanakaara;
    }

    /**
     * @param vachanakaara The vachanakaara
     */
    public void setVachanakaara(Vachanakaara vachanakaara) {
      this.vachanakaara = vachanakaara;
    }
  }

  public class Vachanakaara {

    @SerializedName("name") @Expose private String name;

    /**
     * @return The name
     */
    public String getName() {
      return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
      this.name = name;
    }
  }
}
