package com.example.android.rouxacademy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends ActionBarActivity {

    protected String courseTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        courseTitle = getIntent().getStringExtra(MainActivity.COURSE_TITLE);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(courseTitle);

        String courseDesc = getIntent().getStringExtra(MainActivity.COURSE_DESC);
        TextView tvDesc = (TextView) findViewById(R.id.tvDescription);
        tvDesc.setText(courseDesc);

        // Set up Course#
        int courseNumber = getIntent().getIntExtra(MainActivity.COURSE_NUMBER, 0);
        TextView tvCourseNumber = (TextView) findViewById(R.id.tvCourseNumber);
        tvCourseNumber.setText("Course#: " + courseNumber);
        // Set up Credits
        // Set up Course#
        double credits = getIntent().getDoubleExtra(MainActivity.COURSE_CREDITS, 0);
        TextView tvCourseCredits = (TextView) findViewById(R.id.tvCredits);
        tvCourseCredits.setText("Credits: " + credits);
        // get the Image
       // Image imCourse = getIntent().getMParcelableExtra()
        // Set new image
        ImageView iv = (ImageView) findViewById(R.id.imageCourse);
        iv.setImageResource(getIntent().getIntExtra(MainActivity.PICTURE_RES, 0));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registerClickHandler(View view) {

        getIntent().putExtra("resultMessage", "You're registered for " + courseTitle);
        setResult(RESULT_OK, getIntent());

        // Display the message
        Toast.makeText(this, "Congratulations!\nYou're registered for " + courseTitle, Toast.LENGTH_LONG).show();

        finish();

    }
}
