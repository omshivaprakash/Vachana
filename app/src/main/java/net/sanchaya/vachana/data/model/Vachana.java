package net.sanchaya.vachana.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Vachana implements Parcelable {
  int id;
  String name;

  public Vachana(int mId, String mName) {
    super();
    id = mId;
    name = mName;
  }

  public int getId() {
    return id;
  }

  public void setId(int mId) {
    id = mId;
  }

  public String getName() {
    return name;
  }

  public void setName(String mName) {
    name = mName;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.name);
  }

  protected Vachana(Parcel in) {
    this.id = in.readInt();
    this.name = in.readString();
  }

  public static final Creator<Vachana> CREATOR = new Creator<Vachana>() {
    @Override public Vachana createFromParcel(Parcel source) {
      return new Vachana(source);
    }

    @Override public Vachana[] newArray(int size) {
      return new Vachana[size];
    }
  };
}
