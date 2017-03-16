package com.thyago.sqlitetherightway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.edit_text_todo_description)
    EditText mEditTextTodoDescription;

    @BindView(R.id.list_todo)
    ListView mListTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        int i = 1000;
//        while (i-- > 0)
//            TodoDao.insert(this, "Description " + i);
        refresh();
    }

    @OnClick(R.id.button_add)
    void add() {
        TodoDao.insert(this, mEditTextTodoDescription.getText().toString());
        mEditTextTodoDescription.setText("");

        refresh();
    }

    void refresh() {
        String[] items = TodoDao.fetchAll(this);
        mListTodo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

}
