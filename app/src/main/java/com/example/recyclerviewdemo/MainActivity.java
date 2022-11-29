package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 42. after AppCompatActivity --> add "implements CourseRecyclerviewInterface"
// + implement its methods

public class MainActivity extends AppCompatActivity implements CourseRecyclerviewInterface {
    // 1. change constraintLayout on XML to RecyclerView layout
    // 2. declare an object from recyclerView:
    RecyclerView mRecyclerView;

    // 12. need to create a list of objects from the course class:
    private List<Course> courseList = new ArrayList<>();

    // 26. need to create instance of adapter class and connect the adapter to the recyclerview:
    private CourseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3. instantiate rvList. create instance for rvList in this controller:
        mRecyclerView = findViewById(R.id.rvList);


        // 4. must instantiate layoutmanager and set up linearLayoutMaanger and need to
        // 4 (cont.). pass the context of the application using getApplicationContext():
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        // 5. use the layout manager instance to pass the linear layoutManager object we created in
        // step 4:
        mRecyclerView.setLayoutManager(layoutManager);

        // 6. create new Java class for hardcoded dataset and name the class 'Course' (ALWAYS first
        // letter capital for java classes)



        //16. must getData() to populate the test data list:
        getData();

        // 17. implement another java Class --> CourseAdapter


        //48. add parameter to adapter = new CourseAdapter()
        // --> adapter = new CourseAdapter(courseList, this)
        // 'this' = means the instance from the interface (since we already implemented the
        // interface in this class)

        //49. need to pass on this instance to MyViewHolder in CourseAdapter also.

        //27. put in adapter = new CourseAdapter(); :
        adapter = new CourseAdapter(courseList, this);
        //32. (ABOVE line) pass the courseList

        //28. set Adapter for recyclerView and pass on the adapter object in 27. :
        mRecyclerView.setAdapter(adapter);

        //29. go to CourseAdapter and change getItemCount() to return 10 (show 10 viewholders)
        //30. change ConstraintLayout in XML file: layout_height = wrap_content
        //31. Create constructor method in CourseAdapter class






    }
    // 11(cont.). create new private method to getData():
    private void getData() {

        // 13. decide to do 30 random courses (loop through 20 times):
        for(int i=0; i < 30; i++) {

            // 14. need to create an id code and name; need to have an instance from the Course
            // class and add a code and a name and and them to the arrayList
            // 14(cont.) instatiate an object from the Course class:
            Course course = new Course(String.valueOf(i), "Course " + String.valueOf(i));
            // in above line --> we are calling constructor method for the Course class and because
            // consturctor method has 2 parameters (course code, course name)
            // must pass 2 parameters for course code and course name

            // 15. everytime we create a new course object, must add it to the list
            // (call the object):
            courseList.add(course);

        }

    }

    //43. after 'implement methods' --> it automatically adds empty method below (instance of
    // course interface):
    @Override
    public void onCourseClick(int position) {
        //52(cont.) find the course based on its position:
        // saying --> give me the course which has the position exact same as the position of the
        // item in the adapter class: --> Course course = courseList.get(position);
        Course course = courseList.get(position);

        //53. now know which course we have got so now we can display the name of the course for us
        // in a small pop-up:
        // --> Toast.makeText(this, course.getName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, course.getName(), Toast.LENGTH_SHORT).show();

    }
    //44. go to constructor method for the Adapter class (courseAdapter)

}