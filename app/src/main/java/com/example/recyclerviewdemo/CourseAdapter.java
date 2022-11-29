package com.example.recyclerviewdemo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 18. create subclass in java through "extend":
// 19. need to pass on viewHolder --> each row/item on the list is a viewholder

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {
    //33.
    private List<Course> mCourses;

    //45. add another attribute to class:
    private CourseRecyclerviewInterface mInterface;



    //46. BELOW: need to pass on instance from same interface from MainActivity to here
    // in public CourseAdapter -->
    // public CourseAdapter(List<Course> courses, CourseRecyclerviewInterface.courseInterface) {

    //31. create constructor method in courseAdapter class and pass List of Course class object:
    //  --> public CourseAdapter(List<Course> courses) { }
    public CourseAdapter(List<Course> courses, CourseRecyclerviewInterface courseInterface) {
        //34.
        mCourses = courses;

        //47.
        mInterface = courseInterface;
        //48. go to MainActivity --> adapter = new CourseAdapter...

    }



    // 19(cont.) "implement methods" to implement the abstract methods:
    // 20. add new XML file to decide viewholder layout

    @NonNull

    @Override
    // creates the ViewHolder
    public CourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //24. need to specify the layout we created and implement it here:
        // instantiate object from the view class:
        // LayoutInflater is the class we are going to use:
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,
                false);

        //25. instead of returning null, we return the viewholder we created but need to pass on
        // this view object to the constructor method
        // --> return new MyViewHolder(view);
        return new MyViewHolder(view, mInterface);
        //50. ABOVE:  pass on instance to MyViewHolder
        // --> return new MyViewHolder(view, mInterface);
        // and hover red line to add 2nd parameter to automatically add
    }

    @Override
    // sets/assign data for every ViewHolder
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {
        //36. bind course object:
        Course course = mCourses.get(position);

        //37. get code and name
        holder.mCode.setText(course.getCode());
        holder.mName.setText(course.getName());


    }

    @Override
    // gives the size of the list/ number of items in the recyclerView
    public int getItemCount() {
        //35. change return value to mCourses.size(); to set the list size dynamically:
        return mCourses.size();
    }

    //21. implement myViewHolder sub-class & implement constructor
    class MyViewHolder extends RecyclerView.ViewHolder {
        //22. need to have 2 textview components (for code and for name):
        private TextView mCode, mName;


        public MyViewHolder(@NonNull View itemView, CourseRecyclerviewInterface mInterface) {
            super(itemView);
            //23.for the itemView need to set the view elements for 1 viewholder (code and name):
            // finding the view element from the view and then set:
            mCode = itemView.findViewById(R.id.codeTv);
            mName = itemView.findViewById(R.id.nameTv);

            //38. adding recyclerView to the itemView so that when we click
            // instantiate new object from the onCLickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //51.if anyone clicks on each itemview, we want to get the interface object and
                    //its method and pass on position of that item on the list to the onCourseClick:
                    // --> mInterface.onCourseClick(getAdapterPosition());
                    mInterface.onCourseClick(getAdapterPosition());

                    //52. go to MainActivity --> public void onCourseClick...

                }
            });

            //39. add new java class INTERFACE called CourseRecyclerviewInterface
            // in OOP --> interface is an abstract --> meaning don't have any implementation for it
            // instead have a list of methods for that interface and whenever in application want
            // to use the interface, you need to implement the method for that interface

        }
    }
}
