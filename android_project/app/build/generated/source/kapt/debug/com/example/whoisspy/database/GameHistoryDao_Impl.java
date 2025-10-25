package com.example.whoisspy.database;

import android.database.Cursor;
import android.os.CancellationSignal;
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
import com.example.whoisspy.models.GameHistory;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GameHistoryDao_Impl implements GameHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameHistory> __insertionAdapterOfGameHistory;

  private final DateConverter __dateConverter = new DateConverter();

  private final EntityDeletionOrUpdateAdapter<GameHistory> __deletionAdapterOfGameHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public GameHistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameHistory = new EntityInsertionAdapter<GameHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `game_history` (`id`,`gameTime`,`playerCount`,`spyCount`,`whiteboardCount`,`civilianWord`,`spyWord`,`winnerRole`,`gameMode`,`duration`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameHistory entity) {
        statement.bindLong(1, entity.getId());
        final Long _tmp = __dateConverter.dateToTimestamp(entity.getGameTime());
        if (_tmp == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, _tmp);
        }
        statement.bindLong(3, entity.getPlayerCount());
        statement.bindLong(4, entity.getSpyCount());
        statement.bindLong(5, entity.getWhiteboardCount());
        if (entity.getCivilianWord() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getCivilianWord());
        }
        if (entity.getSpyWord() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSpyWord());
        }
        if (entity.getWinnerRole() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getWinnerRole());
        }
        if (entity.getGameMode() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getGameMode());
        }
        statement.bindLong(10, entity.getDuration());
      }
    };
    this.__deletionAdapterOfGameHistory = new EntityDeletionOrUpdateAdapter<GameHistory>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `game_history` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameHistory entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM game_history";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM game_history WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final GameHistory gameHistory,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfGameHistory.insertAndReturnId(gameHistory);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final GameHistory gameHistory,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGameHistory.handle(gameHistory);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteById(final int id, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            final Integer _result = _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<GameHistory>> getAllGameHistory() {
    final String _sql = "SELECT * FROM game_history ORDER BY gameTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"game_history"}, new Callable<List<GameHistory>>() {
      @Override
      @NonNull
      public List<GameHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGameTime = CursorUtil.getColumnIndexOrThrow(_cursor, "gameTime");
          final int _cursorIndexOfPlayerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playerCount");
          final int _cursorIndexOfSpyCount = CursorUtil.getColumnIndexOrThrow(_cursor, "spyCount");
          final int _cursorIndexOfWhiteboardCount = CursorUtil.getColumnIndexOrThrow(_cursor, "whiteboardCount");
          final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
          final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
          final int _cursorIndexOfWinnerRole = CursorUtil.getColumnIndexOrThrow(_cursor, "winnerRole");
          final int _cursorIndexOfGameMode = CursorUtil.getColumnIndexOrThrow(_cursor, "gameMode");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final List<GameHistory> _result = new ArrayList<GameHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GameHistory _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Date _tmpGameTime;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfGameTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfGameTime);
            }
            _tmpGameTime = __dateConverter.fromTimestamp(_tmp);
            final int _tmpPlayerCount;
            _tmpPlayerCount = _cursor.getInt(_cursorIndexOfPlayerCount);
            final int _tmpSpyCount;
            _tmpSpyCount = _cursor.getInt(_cursorIndexOfSpyCount);
            final int _tmpWhiteboardCount;
            _tmpWhiteboardCount = _cursor.getInt(_cursorIndexOfWhiteboardCount);
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
            final String _tmpWinnerRole;
            if (_cursor.isNull(_cursorIndexOfWinnerRole)) {
              _tmpWinnerRole = null;
            } else {
              _tmpWinnerRole = _cursor.getString(_cursorIndexOfWinnerRole);
            }
            final String _tmpGameMode;
            if (_cursor.isNull(_cursorIndexOfGameMode)) {
              _tmpGameMode = null;
            } else {
              _tmpGameMode = _cursor.getString(_cursorIndexOfGameMode);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            _item = new GameHistory(_tmpId,_tmpGameTime,_tmpPlayerCount,_tmpSpyCount,_tmpWhiteboardCount,_tmpCivilianWord,_tmpSpyWord,_tmpWinnerRole,_tmpGameMode,_tmpDuration);
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
  public Object getRecentGameHistory(final int limit,
      final Continuation<? super List<GameHistory>> $completion) {
    final String _sql = "SELECT * FROM game_history ORDER BY gameTime DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<GameHistory>>() {
      @Override
      @NonNull
      public List<GameHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGameTime = CursorUtil.getColumnIndexOrThrow(_cursor, "gameTime");
          final int _cursorIndexOfPlayerCount = CursorUtil.getColumnIndexOrThrow(_cursor, "playerCount");
          final int _cursorIndexOfSpyCount = CursorUtil.getColumnIndexOrThrow(_cursor, "spyCount");
          final int _cursorIndexOfWhiteboardCount = CursorUtil.getColumnIndexOrThrow(_cursor, "whiteboardCount");
          final int _cursorIndexOfCivilianWord = CursorUtil.getColumnIndexOrThrow(_cursor, "civilianWord");
          final int _cursorIndexOfSpyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "spyWord");
          final int _cursorIndexOfWinnerRole = CursorUtil.getColumnIndexOrThrow(_cursor, "winnerRole");
          final int _cursorIndexOfGameMode = CursorUtil.getColumnIndexOrThrow(_cursor, "gameMode");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final List<GameHistory> _result = new ArrayList<GameHistory>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final GameHistory _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final Date _tmpGameTime;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfGameTime)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfGameTime);
            }
            _tmpGameTime = __dateConverter.fromTimestamp(_tmp);
            final int _tmpPlayerCount;
            _tmpPlayerCount = _cursor.getInt(_cursorIndexOfPlayerCount);
            final int _tmpSpyCount;
            _tmpSpyCount = _cursor.getInt(_cursorIndexOfSpyCount);
            final int _tmpWhiteboardCount;
            _tmpWhiteboardCount = _cursor.getInt(_cursorIndexOfWhiteboardCount);
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
            final String _tmpWinnerRole;
            if (_cursor.isNull(_cursorIndexOfWinnerRole)) {
              _tmpWinnerRole = null;
            } else {
              _tmpWinnerRole = _cursor.getString(_cursorIndexOfWinnerRole);
            }
            final String _tmpGameMode;
            if (_cursor.isNull(_cursorIndexOfGameMode)) {
              _tmpGameMode = null;
            } else {
              _tmpGameMode = _cursor.getString(_cursorIndexOfGameMode);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            _item = new GameHistory(_tmpId,_tmpGameTime,_tmpPlayerCount,_tmpSpyCount,_tmpWhiteboardCount,_tmpCivilianWord,_tmpSpyWord,_tmpWinnerRole,_tmpGameMode,_tmpDuration);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTotalGames(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM game_history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCivilianWins(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM game_history WHERE winnerRole = '平民' OR winnerRole = '平民胜利'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getSpyWins(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM game_history WHERE winnerRole = '卧底' OR winnerRole = '卧底胜利'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
