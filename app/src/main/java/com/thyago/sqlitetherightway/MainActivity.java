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

        String[] items = {"First", "Second", "Third", "And this shit goes a long way. A-ha!"};
        mListTodo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    @OnClick(R.id.button_add)
    void add() {
        Log.d(LOG_TAG, "Button Add");
    }

}
