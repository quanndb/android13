package com.example.anassert.KEHOACH;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.anassert.DBHelper;

import java.util.ArrayList;

public class KeHoachDAO {

    private DBHelper dbHelper;

    SQLiteDatabase db;

    public KeHoachDAO(Context context){
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(KeHoachObject item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("updateDate",item.getUpdateDate());
        contentValues.put("IDSV",item.getIDSV());
        long res = db.insert("tblKH",null,contentValues);
        return res;
    }

    public long update(int id, KeHoachObject item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("updateDate",item.getUpdateDate());
        contentValues.put("IDSV",item.getIDSV());
        long res = db.update("tblKH", contentValues,"ID=?",new String[]{String.valueOf(id)});
        return res;
    }

    public long delete(int id){
        long res = db.delete("tblKH","ID=?",new String[]{String.valueOf(id)});
        if(res == -1 ) return 0;
        return 1;
    }

    @SuppressLint("Range")
    public KeHoachObject getKH (int userID){
        ArrayList<KeHoachObject> listKH = new ArrayList<>();
        // Câu truy vấn kiểm tra xem username có tồn tại không
        String query = "SELECT * FROM tblKH WHERE IDSV = ?";
        String selectionArgs[] = {userID+""};

        // Thực hiện truy vấn
        Cursor cursor = db.rawQuery(query,selectionArgs);

        if (cursor.moveToFirst()) {
            // Truy cập dữ liệu từ Cursor

            String updateDate = cursor.getString(cursor.getColumnIndex("updateDate"));
            int IDSV = cursor.getInt(cursor.getColumnIndex("IDSV"));

            KeHoachObject newKH = new KeHoachObject(updateDate,IDSV);
            cursor.close();
            return newKH;
        }
        // Đóng Cursor
        cursor.close();
        return null;
    }
}
