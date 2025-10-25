package com.example.whoisspy.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile WordPairDao _wordPairDao;

  private volatile GameHistoryDao _gameHistoryDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `word_pairs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `civilianWord` TEXT NOT NULL, `spyWord` TEXT NOT NULL, `category` TEXT NOT NULL, `isCustom` INTEGER NOT NULL, `createTime` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `game_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `gameTime` INTEGER NOT NULL, `playerCount` INTEGER NOT NULL, `spyCount` INTEGER NOT NULL, `whiteboardCount` INTEGER NOT NULL, `civilianWord` TEXT NOT NULL, `spyWord` TEXT NOT NULL, `winnerRole` TEXT NOT NULL, `gameMode` TEXT NOT NULL, `duration` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '429026bbf12d6fc8dd2be3b6636265ff')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `word_pairs`");
        db.execSQL("DROP TABLE IF EXISTS `game_history`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsWordPairs = new HashMap<String, TableInfo.Column>(6);
        _columnsWordPairs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordPairs.put("civilianWord", new TableInfo.Column("civilianWord", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordPairs.put("spyWord", new TableInfo.Column("spyWord", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordPairs.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordPairs.put("isCustom", new TableInfo.Column("isCustom", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordPairs.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWordPairs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWordPairs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWordPairs = new TableInfo("word_pairs", _columnsWordPairs, _foreignKeysWordPairs, _indicesWordPairs);
        final TableInfo _existingWordPairs = TableInfo.read(db, "word_pairs");
        if (!_infoWordPairs.equals(_existingWordPairs)) {
          return new RoomOpenHelper.ValidationResult(false, "word_pairs(com.example.whoisspy.models.WordPair).\n"
                  + " Expected:\n" + _infoWordPairs + "\n"
                  + " Found:\n" + _existingWordPairs);
        }
        final HashMap<String, TableInfo.Column> _columnsGameHistory = new HashMap<String, TableInfo.Column>(10);
        _columnsGameHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("gameTime", new TableInfo.Column("gameTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("playerCount", new TableInfo.Column("playerCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("spyCount", new TableInfo.Column("spyCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("whiteboardCount", new TableInfo.Column("whiteboardCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("civilianWord", new TableInfo.Column("civilianWord", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("spyWord", new TableInfo.Column("spyWord", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("winnerRole", new TableInfo.Column("winnerRole", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("gameMode", new TableInfo.Column("gameMode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameHistory.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGameHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGameHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGameHistory = new TableInfo("game_history", _columnsGameHistory, _foreignKeysGameHistory, _indicesGameHistory);
        final TableInfo _existingGameHistory = TableInfo.read(db, "game_history");
        if (!_infoGameHistory.equals(_existingGameHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "game_history(com.example.whoisspy.models.GameHistory).\n"
                  + " Expected:\n" + _infoGameHistory + "\n"
                  + " Found:\n" + _existingGameHistory);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "429026bbf12d6fc8dd2be3b6636265ff", "2e5dfe1b2c12d3357c8ea1278ff5843f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "word_pairs","game_history");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `word_pairs`");
      _db.execSQL("DELETE FROM `game_history`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WordPairDao.class, WordPairDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GameHistoryDao.class, GameHistoryDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public WordPairDao wordPairDao() {
    if (_wordPairDao != null) {
      return _wordPairDao;
    } else {
      synchronized(this) {
        if(_wordPairDao == null) {
          _wordPairDao = new WordPairDao_Impl(this);
        }
        return _wordPairDao;
      }
    }
  }

  @Override
  public GameHistoryDao gameHistoryDao() {
    if (_gameHistoryDao != null) {
      return _gameHistoryDao;
    } else {
      synchronized(this) {
        if(_gameHistoryDao == null) {
          _gameHistoryDao = new GameHistoryDao_Impl(this);
        }
        return _gameHistoryDao;
      }
    }
  }
}
