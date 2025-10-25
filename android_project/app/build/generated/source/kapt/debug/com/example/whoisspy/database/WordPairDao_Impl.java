package com.example.whoisspy.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.whoisspy.models.WordPair;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WordPairDao_Impl implements WordPairDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WordPair> __insertionAdapterOfWordPair;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<WordPair> __deletionAdapterOfWordPair;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCustomWordPairById;

  public WordPairDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWordPair = new EntityInsertionAdapter<WordPair>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `word_pairs` (`id`,`civilianWord`,`spyWord`,`category`,`isCustom`,`createTime`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WordPair entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCivilianWord() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCivilianWord());
        }
        if (entity.getSpyWord() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSpyWord());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        final int _tmp = entity.isCustom() ? 1 : 0;
        statement.bindLong(5, _tmp);
        final Long _tmp_1 = __dateConverter.dateToTimestamp(entity.getCreateTime());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp_1);
        }
      }
    };
    this.__deletionAdapterOfWordPair = new EntityDeletionOrUpdateAdapter<WordPair>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `word_pairs` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WordPair entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteCustomWordPairById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM word_pairs WHERE id = ? AND isCustom = 1";
        return _query;
      }
    };
  }

  @Override
  public long insert(final WordPair wordPair) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfWordPair.insertAndReturnId(wordPair);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<WordPair> wordPairs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWordPair.insert(wordPairs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final WordPair wordPair) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWordPair.handle(wordPair);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteCustomWordPairById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCustomWordPairById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        final int _result = _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteCustomWordPairById.release(_stmt);
    }
  }

  @Override
  public Flow<List<WordPair>> getAllWordPairs() {
    final String _sql = "SELECT * FROM word_pairs ORDER BY createTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"word_pairs"}, new Callable<List<WordPair>>() {
      @Override
      @NonNull
      public List<WordPair> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
          final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsCustom = CursorUtil.getColumnIndexOrThrow(_cursor, "isCustom");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<WordPair> _result = new ArrayList<WordPair>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WordPair _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCivilianWord;
            if (_cursor.isNull(_cursorIndexOfCivilianWord)) {
              _tmpCivilianWord = null;
            } else {
              _tmpCivilianWord = _cursor.getString(_cursorIndexOfCivilianWord);
            }
            final String _tmpSpyWord;
            if (_cursor.isNull(_cursorIndexOfSpyWord)) {
              _tmpSpyWord = null;
            } else {
              _tmpSpyWord = _cursor.getString(_cursorIndexOfSpyWord);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsCustom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCustom);
            _tmpIsCustom = _tmp != 0;
            final Date _tmpCreateTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreateTime);
            }
            _tmpCreateTime = __dateConverter.fromTimestamp(_tmp_1);
            _item = new WordPair(_tmpId,_tmpCivilianWord,_tmpSpyWord,_tmpCategory,_tmpIsCustom,_tmpCreateTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WordPair>> getWordPairsByCategory(final String category) {
    final String _sql = "SELECT * FROM word_pairs WHERE category = ? ORDER BY createTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"word_pairs"}, new Callable<List<WordPair>>() {
      @Override
      @NonNull
      public List<WordPair> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
          final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsCustom = CursorUtil.getColumnIndexOrThrow(_cursor, "isCustom");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<WordPair> _result = new ArrayList<WordPair>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WordPair _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCivilianWord;
            if (_cursor.isNull(_cursorIndexOfCivilianWord)) {
              _tmpCivilianWord = null;
            } else {
              _tmpCivilianWord = _cursor.getString(_cursorIndexOfCivilianWord);
            }
            final String _tmpSpyWord;
            if (_cursor.isNull(_cursorIndexOfSpyWord)) {
              _tmpSpyWord = null;
            } else {
              _tmpSpyWord = _cursor.getString(_cursorIndexOfSpyWord);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsCustom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCustom);
            _tmpIsCustom = _tmp != 0;
            final Date _tmpCreateTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreateTime);
            }
            _tmpCreateTime = __dateConverter.fromTimestamp(_tmp_1);
            _item = new WordPair(_tmpId,_tmpCivilianWord,_tmpSpyWord,_tmpCategory,_tmpIsCustom,_tmpCreateTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WordPair>> getCustomWordPairs() {
    final String _sql = "SELECT * FROM word_pairs WHERE isCustom = 1 ORDER BY createTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"word_pairs"}, new Callable<List<WordPair>>() {
      @Override
      @NonNull
      public List<WordPair> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
          final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsCustom = CursorUtil.getColumnIndexOrThrow(_cursor, "isCustom");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<WordPair> _result = new ArrayList<WordPair>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WordPair _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCivilianWord;
            if (_cursor.isNull(_cursorIndexOfCivilianWord)) {
              _tmpCivilianWord = null;
            } else {
              _tmpCivilianWord = _cursor.getString(_cursorIndexOfCivilianWord);
            }
            final String _tmpSpyWord;
            if (_cursor.isNull(_cursorIndexOfSpyWord)) {
              _tmpSpyWord = null;
            } else {
              _tmpSpyWord = _cursor.getString(_cursorIndexOfSpyWord);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsCustom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCustom);
            _tmpIsCustom = _tmp != 0;
            final Date _tmpCreateTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreateTime);
            }
            _tmpCreateTime = __dateConverter.fromTimestamp(_tmp_1);
            _item = new WordPair(_tmpId,_tmpCivilianWord,_tmpSpyWord,_tmpCategory,_tmpIsCustom,_tmpCreateTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WordPair>> getDefaultWordPairs() {
    final String _sql = "SELECT * FROM word_pairs WHERE isCustom = 0 ORDER BY createTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"word_pairs"}, new Callable<List<WordPair>>() {
      @Override
      @NonNull
      public List<WordPair> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
          final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsCustom = CursorUtil.getColumnIndexOrThrow(_cursor, "isCustom");
          final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
          final List<WordPair> _result = new ArrayList<WordPair>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WordPair _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCivilianWord;
            if (_cursor.isNull(_cursorIndexOfCivilianWord)) {
              _tmpCivilianWord = null;
            } else {
              _tmpCivilianWord = _cursor.getString(_cursorIndexOfCivilianWord);
            }
            final String _tmpSpyWord;
            if (_cursor.isNull(_cursorIndexOfSpyWord)) {
              _tmpSpyWord = null;
            } else {
              _tmpSpyWord = _cursor.getString(_cursorIndexOfSpyWord);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsCustom;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCustom);
            _tmpIsCustom = _tmp != 0;
            final Date _tmpCreateTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCreateTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfCreateTime);
            }
            _tmpCreateTime = __dateConverter.fromTimestamp(_tmp_1);
            _item = new WordPair(_tmpId,_tmpCivilianWord,_tmpSpyWord,_tmpCategory,_tmpIsCustom,_tmpCreateTime);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public WordPair getRandomWordPair(final String category) {
    final String _sql = "SELECT * FROM word_pairs WHERE category = ? OR category = '默认' ORDER BY RANDOM() LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
      final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsCustom = CursorUtil.getColumnIndexOrThrow(_cursor, "isCustom");
      final int _cursorIndexOfCreateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "createTime");
      final WordPair _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpCivilianWord;
        if (_cursor.isNull(_cursorIndexOfCivilianWord)) {
          _tmpCivilianWord = null;
        } else {
          _tmpCivilianWord = _cursor.getString(_cursorIndexOfCivilianWord);
        }
        final String _tmpSpyWord;
        if (_cursor.isNull(_cursorIndexOfSpyWord)) {
          _tmpSpyWord = null;
        } else {
          _tmpSpyWord = _cursor.getString(_cursorIndexOfSpyWord);
        }
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        final boolean _tmpIsCustom;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsCustom);
        _tmpIsCustom = _tmp != 0;
        final Date _tmpCreateTime;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfCreateTime)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfCreateTime);
        }
        _tmpCreateTime = __dateConverter.fromTimestamp(_tmp_1);
        _result = new WordPair(_tmpId,_tmpCivilianWord,_tmpSpyWord,_tmpCategory,_tmpIsCustom,_tmpCreateTime);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getAllCategories() {
    final String _sql = "SELECT DISTINCT category FROM word_pairs ORDER BY category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
