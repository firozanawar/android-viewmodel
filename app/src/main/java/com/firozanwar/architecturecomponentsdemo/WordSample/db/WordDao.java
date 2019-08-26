package com.firozanwar.architecturecomponentsdemo.WordSample.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.firozanwar.architecturecomponentsdemo.WordSample.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insertWord(Word word);

    @Query("DELETE from word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
