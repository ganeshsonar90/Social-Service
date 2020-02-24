package com.task.data.models.db


import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "category")
class Category() : Parcelable {


    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


    @ColumnInfo
    var categoryId: Int = 0

    @ColumnInfo
    var title: String = ""


    @ColumnInfo
    var shortDescription: String = ""

    @ColumnInfo
    var collectedValue: Int = 0

    @ColumnInfo
    var totalValue: Int = 0


    @ColumnInfo
    var startDate: String = ""

    @ColumnInfo
    var endDate: String = ""


    @ColumnInfo
    var mainImageURL: String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        categoryId = parcel.readInt()
        title = parcel.readString()!!
        shortDescription = parcel.readString()!!
        collectedValue = parcel.readInt()
        totalValue = parcel.readInt()
        startDate = parcel.readString()!!
        endDate = parcel.readString()!!
        mainImageURL = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(categoryId)
        parcel.writeString(title)
        parcel.writeString(shortDescription)
        parcel.writeInt(collectedValue)
        parcel.writeInt(totalValue)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeString(mainImageURL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }


}