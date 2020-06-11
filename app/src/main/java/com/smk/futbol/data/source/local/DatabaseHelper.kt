package com.smk.futbol.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.smk.futbol.model.Favorite
import org.jetbrains.anko.db.*

class DatabaseHelper(context: Context): ManagedSQLiteOpenHelper(context, "FavoriteMatch.db", null, 1) {
    companion object {
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseHelper {
            if (instance == null) {
                instance =
                    DatabaseHelper(ctx.applicationContext)
            }
            return instance as DatabaseHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(
            Favorite.TABLE_FAVORITE, true,
            Favorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Favorite.MATCH_ID to TEXT + UNIQUE,
            Favorite.MATCH_DATE to TEXT,
            Favorite.HOME_NAME to TEXT,
            Favorite.AWAY_NAME to TEXT,
            Favorite.HOME_SCORE to TEXT,
            Favorite.AWAY_SCORE to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(Favorite.TABLE_FAVORITE, true)
    }
}

val Context.database: DatabaseHelper
get() = DatabaseHelper.getInstance(
    applicationContext
)