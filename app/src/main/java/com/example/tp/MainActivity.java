package com.example.tp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;

import com.example.tp.data.InitDatabase;
import com.example.tp.data.bdd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.invoke.ConstantCallSite;
import java.time.Month;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private DatePickerDialog.OnDateSetListener onDateSetListener;

    Button btn_save;
    EditText editText_filed_name;
    TextView textView_movie;
    String titleString = new String();
    TextView txv;
    TextView txvTime;
    Context mContext = this;
    Spinner SpinnerScenario;
    Spinner SpinnerRea;
    Spinner SpinnerMusic;
    Button Button_Movie;
    EditText EditTextDesc;
    EditText EditTextMovie;
    Button ButtonShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_form);

        /*Find view by ID*/
        ButtonShow = (Button)findViewById(R.id.ButtonShow);

        btn_save = (Button)findViewById(R.id.Button_Movie);
        editText_filed_name = (EditText)findViewById(R.id.EditTextMovie);
        EditTextMovie = (EditText)findViewById(R.id.EditTextMovie);
        textView_movie = (TextView)findViewById(R.id.TextViewMovie);
        txv = (TextView)findViewById(R.id.txvDate);
        txvTime = (TextView)findViewById(R.id.txvTime);
        Button_Movie = (Button)findViewById(R.id.Button_Movie);
        EditTextDesc = (EditText) findViewById(R.id.EditTextDesc);
        SpinnerScenario = (Spinner)findViewById(R.id.SpinnerScenario);
        SpinnerRea = (Spinner)findViewById(R.id.SpinnerRea);
        SpinnerMusic = (Spinner)findViewById(R.id.SpinnerMusic);




        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            titleString = (String)editText_filed_name.getText().toString();
            textView_movie.setText(titleString);
            }
        });




        txv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog  = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,onDateSetListener,year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 month = month+1;
                String date = dayOfMonth + "/" + month + "/" + year;
                txv.setText(date);
            }
        };

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        txvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txvTime.setText(hourOfDay + ":" + minute);
                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();
            }
        });


        Button_Movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    bdd dbHelper = new bdd(v.getContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(bdd.COLUMN_DATE, txv.getText().toString());

                    values.put(bdd.COLUMN_DATE, txv.getText().toString());
                    values.put(bdd.COLUMN_HEURE, txvTime.getText().toString());
                    values.put(bdd.COLUMN_HEURE, EditTextDesc.getText().toString());
                values.put(bdd.COLUMN_Film, EditTextMovie.getText().toString());

                    values.put(bdd.COLUMN_REALISATEUR, String.valueOf(SpinnerRea));
                    values.put(bdd.COLUMN_SCENARIO, String.valueOf(SpinnerScenario));
                    values.put(bdd.COLUMN_MUSIQUE, String.valueOf(SpinnerMusic));

                    //insert bdd
                    long newRowId = db.insert(bdd.DATABASE_NAME, null, values);


                    //clear
                EditTextMovie.setText("");
                EditTextDesc.setText("");
                    txvTime.setText("");
                    txv.setText("");

            }
        });



        ButtonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = txv.getText().toString();
                String heure = txvTime.getText().toString();
                String description = EditTextDesc.getText().toString();
                //WP SHOW DATA
            }
        });


    }




}
