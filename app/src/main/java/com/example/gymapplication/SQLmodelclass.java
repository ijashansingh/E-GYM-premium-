package com.example.gymapplication;

import android.graphics.Bitmap;

public class SQLmodelclass {
    public Bitmap sqlimageview1;
    public String sqltextview1,sqltextview2;

    public SQLmodelclass(Bitmap sqlimageview1, String sqltextview1, String sqltextview2) {
        this.sqlimageview1 = sqlimageview1;
        this.sqltextview1 = sqltextview1;
        this.sqltextview2 = sqltextview2;
    }

    public Bitmap getSqlimageview1() {
        return sqlimageview1;
    }

    public String getSqltextview1() {
        return sqltextview1;
    }

    public String getSqltextview2() {
        return sqltextview2;
    }


}
