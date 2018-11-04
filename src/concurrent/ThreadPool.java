package concurrent;

public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    void addWorkers(int i);

    void removeWorkers(int i);

    int getJobSize();
}
