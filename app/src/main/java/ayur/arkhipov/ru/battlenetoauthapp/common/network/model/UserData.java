package ayur.arkhipov.ru.battlenetoauthapp.common.network.model;


import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable{

    /**
     * battletag : BIT#22428
     * id : 401122682
     */

    private String battletag;
    private long id;

    protected UserData(Parcel in) {
        battletag = in.readString();
        id = in.readLong();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    public String getBattletag() {
        return battletag;
    }

    public void setBattletag(String battletag) {
        this.battletag = battletag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(battletag);
        parcel.writeLong(id);
    }

}
