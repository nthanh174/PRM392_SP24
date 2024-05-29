package sl_6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    public UserDAO(Context context) {
        dbHelper = new SQLLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("imageUrl", user.getImageUrl());

        database.insert("users", null, values);
    }

    public void updateUser(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("imageUrl", user.getImageUrl());

        database.update("users", values, "id = ?", new String[]{String.valueOf(user.getId())});
    }

    public void deleteUser(User user) {
        database.delete("users", "id = ?", new String[]{String.valueOf(user.getId())});
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Cursor cursor = database.query("users", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                int imageUrl = cursor.getInt(cursor.getColumnIndexOrThrow("imageUrl"));

                users.add(new User(id, name, email, imageUrl));
            } while (cursor.moveToNext());
            cursor.close();
        }

        return users;
    }
}
