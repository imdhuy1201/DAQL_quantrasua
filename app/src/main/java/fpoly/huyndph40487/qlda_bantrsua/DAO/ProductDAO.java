package fpoly.huyndph40487.qlda_bantrsua.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.huyndph40487.qlda_bantrsua.DataBase.DbHelper;
import fpoly.huyndph40487.qlda_bantrsua.Model.Product;

public class ProductDAO {
    private Context context;
    private SQLiteDatabase db;

    public ProductDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        this.context = context;
    }

    @SuppressLint("Range")
    public List<Product> getData(String sql, String... selectionArgs) {
        List<Product> productList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Product product = new Product(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    Integer.parseInt(cursor.getString(cursor.getColumnIndex("Gia"))),
                    cursor.getString(cursor.getColumnIndex("Anh"))
            );
            productList.add(product);
        }
        return productList;
    }

    public List<Product> getAll() {
        String sql = "SELECT * FROM Product";
        return getData(sql);
    }
}
