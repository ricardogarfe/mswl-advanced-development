/*
 * Copyright [2013] [Ricardo García Fernández] [ricardogarfe@gmail.com]
 * 
 * This file is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package es.advantage.development.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/**
 * We define a structure to save the data
 * 
 * @author ricardo
 * 
 */
public class Node implements Parcelable {

    public String mTitle;
    public String mDescription;
    public Integer mImageResource;
    public double mLat;
    public double mLon;

    public Node() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static final Parcelable.Creator<Node> CREATOR = new Creator<Node>() {

        public Node createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Node(source);
        }

        public Node[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Node[size];
        }
    };

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeInt(mImageResource);
        dest.writeDouble(mLat);
        dest.writeDouble(mLon);
    }

    public Node(Parcel in) {

        mTitle = in.readString();
        mDescription = in.readString();
        mImageResource = in.readInt();
        mLat = in.readDouble();
        mLon = in.readDouble();

    }
}
