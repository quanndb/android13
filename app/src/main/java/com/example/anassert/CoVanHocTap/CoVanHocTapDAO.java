package com.example.anassert.CoVanHocTap;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.anassert.ChiTietKH.ChiTietKHObject;
import com.example.anassert.DBHelper;

import java.util.ArrayList;

public class CoVanHocTapDAO {
    private DBHelper dbHelper;

    SQLiteDatabase db;

    public CoVanHocTapDAO(Context context){
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long Create(CoVanHocTapObject item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName",item.FullName);
        contentValues.put("Email",item.Email);
        contentValues.put("PhoneNumber",item.PhoneNumber);
        long res = db.insert("tblCVHT",null,contentValues);
        return res;
    }

    public long Update(int id, CoVanHocTapObject item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName",item.FullName);
        contentValues.put("Email",item.Email);
        contentValues.put("PhoneNumber",item.PhoneNumber);
        long res = db.update("tblCVHT", contentValues,"ID=?",new String[]{String.valueOf(id)});
        return res;
    }

    public long Delete(int Id){
        long res = db.delete("tblCVHT","ID=?",new String[]{String.valueOf(Id)});
        if(res == -1 ) return 0;
        return 1;
    }

    @SuppressLint("Range")
    public ArrayList<CoVanHocTapObject> getAll(String request){
        ArrayList<CoVanHocTapObject> listCVHT = new ArrayList<>();
        // Câu truy vấn kiểm tra xem username có tồn tại không
        String query = "SELECT * FROM tblCVHT WHERE FullName LIKE '%' || " + request + "|| '%'";

        // Thực hiện truy vấn
        Cursor cursor = db.rawQuery(query,null);

// Duyệt qua dữ liệu trong Cursor
        if (cursor != null && cursor.moveToFirst()) {
            do {
                CoVanHocTapObject newCVHT = new CoVanHocTapObject();
                // Lấy dữ liệu từ cột cần thiết
                newCVHT.ID = cursor.getInt(cursor.getColumnIndex("ID"));
                newCVHT.FullName = cursor.getString(cursor.getColumnIndex("FullName"));
                newCVHT.Email = cursor.getString(cursor.getColumnIndex("Email"));
                newCVHT.PhoneNumber = cursor.getString(cursor.getColumnIndex("PhoneNumber"));

                listCVHT.add(newCVHT);
                // Thực hiện xử lý với dữ liệu lấy được
            } while (cursor.moveToNext());

            // Đóng Cursor khi không sử dụng nữa
            cursor.close();
        }

        return listCVHT;
    }
}