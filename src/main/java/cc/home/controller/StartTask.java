package cc.home.controller;

import cc.home.jobber.Task;
import cc.home.jobber.TaskEngine;
import cc.home.jobber.TaskHelper;
import cc.home.jobber.execute.process.TaskProcess;
import cc.home.jobber.execute.task.BaseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by cheng on 2017/1/22 0022.
 */
@RestController
@RequestMapping("task")
public class StartTask {

    @Autowired
    TaskEngine taskEngine;


    @RequestMapping("start")
    public void init() {
        taskEngine.start();
    }

    @RequestMapping("task")
    public void addTask() {
        BaseTask baseTask = new BaseTask(10, 2) {

        };
        baseTask.setTaskProcess(new TaskProcess() {

            private Thread thread;

            private volatile Boolean shutdown = false;

            @Override
            public Object process(Task task) throws Exception {

                thread = Thread.currentThread();
                for(;;){
                    if (shutdown){
                        return null;
                    }
                    System.out.println(this);
                    System.out.println(StartTask.this);
                    Thread.sleep(2000);
                    System.out.println(thread.getId());
                    System.out.println(System.currentTimeMillis());
                }
            }

            @Override
            public void shutdown() throws InterruptedException {
                System.out.println("shutdown ----------------- ----- --" + thread.getId());
                System.out.println("shutdown ----------------- ----- --" + Thread.currentThread().getId());
                synchronized (this) {
                    System.out.println(this);
                    stop();
                }
            }


            private void stop() throws InterruptedException {
                shutdown = true;
                this.wait();
            }

        });
        baseTask.register();
    }

    @RequestMapping("list")
    public Map listTask() {
        return TaskHelper.showTask();
    }

    @RequestMapping("shutdown/{taskNum}")
    public void shutdownTask(@PathVariable("taskNum") String taskNum) {
        TaskHelper.newInstance().shutdown(taskNum);
    }


}
