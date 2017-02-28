package cc.home.controller;

import cc.home.jobber.Task;
import cc.home.jobber.execute.listener.JobListener;
import cc.home.jobber.execute.listener.TaskListener;

/**
 * Created by cheng on 2017/2/15 0015.
 */
@JobListener
public class MyJobListener implements TaskListener {

    public MyJobListener() {
    }

    @Override
    public void onTaskAdd(Task task) {
        System.out.println(this.getClass().getSimpleName()+":"+task.getTaskNum());
    }

    @Override
    public void onProcessError(Task task, Exception e) {
        System.out.println("fuck!!!U!!!");
    }
}
