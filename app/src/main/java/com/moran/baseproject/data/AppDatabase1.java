package com.moran.baseproject.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class,version = 1)
public abstract class AppDatabase1 extends RoomDatabase{


}
