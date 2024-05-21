package sl_5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private SQLiteDatabase database;
    private SQLLiteHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new SQLLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String selectQuery = "SELECT * FROM User";

        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setImageUrl(cursor.getInt(3));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userList;
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("imageUrl", user.getImageUrl());

        database.insert("User", null, values);
    }
}
