package com.firozanwar.architecturecomponentsdemo.WordSample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.firozanwar.architecturecomponentsdemo.WordSample.db.WordDao;
import com.firozanwar.architecturecomponentsdemo.WordSample.db.WordRoomDatabase;
import com.firozanwar.architecturecomponentsdemo.WordSample.model.Word;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insertWord(params[0]);
            return null;
        }
    }
}
