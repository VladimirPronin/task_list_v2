package com.pronin.tasklist_v2.repository.model.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

@Entity(tableName = "item_table")
public class TaskEntity implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;
    @ColumnInfo(name = "title")
    private String mTitle;
    @ColumnInfo(name = "content")
    private String mContent;
    @ColumnInfo(name = "createDate")
    private String mCreateDate;
    @ColumnInfo(name = "geoId")
    private long mGeoId;

    @Inject
    public TaskEntity() {
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public TaskEntity createFromParcel(final Parcel source) {
            return new TaskEntity(source);
        }

        @Override
        public TaskEntity[] newArray(final int size) {
            return new TaskEntity[size];
        }
    };

    public TaskEntity(final long id, final String title, final String content, final String createDate, final long geoId) {
        mId = id;
        mTitle = title;
        mContent = content;
        mCreateDate = createDate;
        mGeoId = geoId;
    }

    public TaskEntity(Parcel source) {
        this.mId = source.readLong();
        this.mTitle = source.readString();
        this.mContent = source.readString();
        this.mCreateDate = source.readString();
        this.mGeoId = source.readLong();
    }

    public long getId() {
        return mId;
    }

    public void setId(final long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(final String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(final String content) {
        mContent = content;
    }

    public String getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(final String createDate) {
        mCreateDate = createDate;
    }

    public long getGeoId() {
        return mGeoId;
    }

    public void setGeoId(final long geoId) {
        mGeoId = geoId;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mContent='" + mContent + '\'' +
                ", mCreateDate='" + mCreateDate + '\'' +
                ", mGeoId=" + mGeoId +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeLong(this.mId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mContent);
        dest.writeString(this.mCreateDate);
        dest.writeLong(this.mGeoId);

    }
}